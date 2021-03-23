package com.goott.eco.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;

import com.goott.eco.config.RootConfig;
import com.goott.eco.domain.GoodsVO;
import com.goott.eco.domain.GoodsVO.GoodsThumbNailVO;

import lombok.Getter;
import lombok.Setter;

/*
    작성자 : 신동우 
    
	쿠팡 사이트 전용 1회용 샘플데이터 생성 클래스입니다.
	
	프로세스 
	1. LIST URL 획득 (쿠팡에서 '친환경' 검색 시 나오는 품목)
	
	2. LIST 목록에서 상품 키값만 획득 하여 LIST 담기
	
	3. 1개 품목에 대한 데이터 수집 프로세스
		- 상품 키를 통하여 상세 페이지 접근.
		- 상품 상세 정보 HTML 문구 획득 -> ' -> '' 파싱 (DB에 오류 없이 넣기 위하여)
		- 테이블에 데이터 INSERT
		- 썸네일 이미지 주소 획득 -> 이미지 DOWNLOAD -> GOODS_DETAIL_THUMB_IMG 테이블 데이터 INSERT (이때 GOODS_SEQ는 위에 상품 값으로 설정)
 */
public class GoodsSampleDataMaker {
	
	private final String CHAR_SET = "UTF-8";
	
	private String listUrl = "https://www.coupang.com/np/search?q=";
	private String searchStr;
	private String pageQuery = "&listSize=100&page=";
	private int currPage = 1;
	
	private String detailUrl = "https://www.coupang.com/vp/products/";
	
	private Document doc;
	
	public GoodsSampleDataMaker() throws UnsupportedEncodingException{
		this.searchStr = URLEncoder.encode("친환경", CHAR_SET);
	}
	
	public GoodsSampleDataMaker(String searchStr) throws UnsupportedEncodingException{
		this.searchStr =  URLEncoder.encode(searchStr, CHAR_SET);
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	
	public static void main(String[] args) throws IOException {
		GoodsSampleDataMaker maker = new GoodsSampleDataMaker();
//		System.out.println(URLEncoder.encode("친환경", maker.CHAR_SET));
		String[] products = maker.getProductIdList();
		
		String tmpUrl = maker.getProductDetailUrl(products[0]);
		maker.getProductInfo(tmpUrl);
		
		
	}
	
	//조회 된 상품 pk 값을 list에 담는다. 
	public String[] getProductIdList() throws IOException{
		this.doc = Jsoup.connect(this.listUrl + this.searchStr + this.pageQuery + this.currPage).get();
		
		String productsStr = doc.getElementById("productList").attr("data-products");
//		System.out.println(productsStr);
		
		productsStr = productsStr.substring(productsStr.indexOf(":[") + 2, productsStr.length() -3).replaceAll(" ", "");
//		System.out.println(productsStr);
		
		String[] products = productsStr.split(","); 
//		System.out.println(Arrays.toString(products));
		
		return products;
	}
	
	//상품 상세 페이지 url 리턴
	public String getProductDetailUrl(String productId) {
		String url = this.detailUrl + productId;
		return url;
	}
	
	//상품 정보 획득 
	public GoodsVO getProductInfo(String url) throws IOException {
 		this.doc = Jsoup.connect(url).get();
 		
		
		String goodsName = doc.select(".prod-buy-header__title").text();
//		System.out.println(goodsName);
		
		String tmpPrice = doc.select(".total-price > strong").text();
//		System.out.println(tmpPrice);
		int price = convertPriceStrToInt(tmpPrice);
//		System.out.println(price);
		
		
		String imgUrl = doc.select("#repImageContainer > .prod-image__detail").attr("src");
//		System.out.println(imgUrl);
		
		GoodsVO goodsVO = new GoodsVO();
		goodsVO.setGoods_name(goodsName);
		goodsVO.setPrice(price);
		goodsVO.setComp_seq(1);
		goodsVO.setCategory(1);
		goodsVO.setReq_option("N");
		goodsVO.setReguser("SYSTEM");
		
		goodsVO.getGoodsThumbNailVO().setImg_url(imgUrl);
		goodsVO.getGoodsThumbNailVO().setMain_yn("Y");
		
		return goodsVO;
	}
	
	//가격 문자열 파싱 ex)(String)"13,500원" -> (int)13500  
	public int convertPriceStrToInt(String price) {
		StringBuilder sb = new StringBuilder();
		
		char[] priceChars = price.toCharArray();
		for(char c : priceChars) {
			if(c >= 48 && c <= 57) { sb.append(c); }
		}
		
		String tmpPrice = sb.toString();
		if(tmpPrice.length() == 0) { 
			tmpPrice = "0"; 
		}else if(tmpPrice.length() > 1 && tmpPrice.charAt(0) == '0') {
			tmpPrice = "0";
		}else if(tmpPrice.length() > 9) {
			tmpPrice = "0";
		}
		
		return Integer.parseInt(tmpPrice); 
	}
}
