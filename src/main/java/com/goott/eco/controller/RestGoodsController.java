package com.goott.eco.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goott.eco.common.Criteria;
import com.goott.eco.service.GoodsService;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

import com.goott.eco.domain.AttachFileDTO;
import com.goott.eco.domain.GoodsVO;
import com.goott.eco.domain.GoodsVO.GoodsThumbNailVO;

@RestController
@RequestMapping("/goods/rest")
@Log4j
public class RestGoodsController {
	
	@Autowired private GoodsService goodsService;

	//???????????????
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Map<String, Object>> goodsList(@ModelAttribute Criteria cri) {
		Map<String, Object> goods = goodsService.goodsList(cri);
		
		return new ResponseEntity<>(goods, HttpStatus.OK);
	}
	
	//???????????????
	@GetMapping(value="/{goodsSeq}/review", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Map<String, Object>> getReview(@PathVariable int goodsSeq, @RequestParam int pageNum) {
		Map<String, Object> comment = goodsService.goodsComment(goodsSeq, pageNum);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
	
	//?????? ??????
	@PostMapping(value="/{goodsSeq}/review/{goodsCommentSeq}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Integer> updateReview(HttpServletRequest request 
												, @PathVariable int goodsSeq
												, @RequestBody GoodsVO.GoodsCommentVO commentVO) {
		String memberId = (String)request.getSession().getAttribute("memberId");
		if(memberId == null || memberId.equals("")) { new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		commentVO.setCust_id(memberId);
		
		int record = goodsService.updateReview(commentVO);
		return record == 1 ? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.BAD_REQUEST);//????????? ?????? ?????? ?????? ????????? ?????? ??????.
	}
	
	//?????? ??????
	@DeleteMapping(value="/{goodsSeq}/review/{goodsCommentSeq}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Integer> deleteReview(HttpServletRequest request 
			, @PathVariable int goodsSeq
			, @RequestBody GoodsVO.GoodsCommentVO commentVO) {
		String memberId = (String)request.getSession().getAttribute("memberId");
		if(memberId == null || memberId.equals("")) { new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		commentVO.setCust_id(memberId);
		
		int record = goodsService.deleteReview(commentVO);
		return record == 1 ? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.BAD_REQUEST);//????????? ?????? ?????? ?????? ????????? ?????? ??????.
	}
	
	//????????????
	@PutMapping(value="/{goodsSeq}/review", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Integer> insertReview(HttpServletRequest request, @PathVariable int goodsSeq
												, @RequestBody GoodsVO.GoodsCommentVO commentVO) {
		String memberId = (String)request.getSession().getAttribute("memberId");
		if(memberId == null || memberId.equals("")) { new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		commentVO.setCust_id(memberId);
		
		int record = goodsService.insertReview(commentVO); 
		return record == 1 ? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.BAD_REQUEST);//????????? ?????? ?????? ?????? ????????? ?????? ??????.
	}
	
	//Naver smart editor?????? temp ????????? ?????? ?????? ??????
	@PostMapping(value="/form/upload/images", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<String> goodsDetailImagesUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile[] multifile) throws IOException {
		//????????????
		String sFileInfo = "";
		//???????????? ????????? - ?????? ???????????????
		String filename = request.getHeader("file-name");
		//?????? ?????????
		String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
		//???????????????????????? ??????
		filename_ext = filename_ext.toLowerCase();
		//?????????????????? + ?????????
		String rlFileNm = "";
			
		//????????? ?????? ????????????
		String[] allow_file = {"jpg","png","bmp","gif"};

		//???????????? ???????????? ??????????????? 
		int cnt = 0;
		for(int i=0; i<allow_file.length; i++) {
			if(filename_ext.equals(allow_file[i])){
				cnt++;
			}
		}

		//???????????? ??????
		if(cnt == 0) {
//			Todo. ???????????? ???????????? return fail_status ?????? ??????.
//			out.println("NOTALLOW_"+filename);
		} else {
			//?????????????????? ?????? ????????? ???????????? ?????? ??? ?????????	
			//?????? ????????????
//			String dftFilePath = request.getServletContext().getRealPath("/");
			String dftFilePath = "c:\\upload\\img\\temp\\";
			//?????? ???????????? _ ????????????
			String filePath = dftFilePath;
			File file = new File(filePath);
			
			if(!file.exists()) { file.mkdirs(); }
			
			String realFileNm = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today= formatter.format(new java.util.Date());
			realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			rlFileNm = filePath + realFileNm;
			
			///////////////// ????????? ???????????? ///////////////// 
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(rlFileNm);
			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			
			while((numRead = is.read(b,0,b.length)) != -1){
				os.write(b,0,numRead);
			}
			
			if(is != null) {
				is.close();
			}
			os.flush();
			os.close();
			///////////////// ????????? ???????????? /////////////////
	
			// ?????? ??????
			sFileInfo += "&bNewLine=true";
			//sFileInfo += "&sFileName="+ realFileNm;;
			// img ????????? title ????????? ????????????????????? ?????????????????? ??????
			sFileInfo += "&sFileName="+ filename;
			sFileInfo += "&sFileURL=" + "/upload/img/temp/" + realFileNm;
		
			}
		
		return new ResponseEntity<>(sFileInfo, HttpStatus.OK);
	}
	
	//????????????
	@PutMapping(value="/form", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> insertGoods(HttpServletRequest request, @RequestBody GoodsVO goodsVO){
//		String[] option_name = request.getParameterValues("req_option_name");
//		String[] option_price = request.getParameterValues("req_price");
		
		String memberId = (String)request.getSession().getAttribute("memberId");
//		Integer compSeq = (Integer)request.getSession().getAttribute("compSeq");

//		String memberId = "compF";
//		int compSeq = 61;
//		goodsVO.setComp_seq(compSeq);
		goodsVO.setReguser(memberId);
		
		String msg = "";
		int goods_seq = goodsService.insertGoods(goodsVO);
		
		return goods_seq > 0 ? new ResponseEntity<>(goods_seq, HttpStatus.OK)
					   : new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//????????? ????????? 
	@PostMapping(value="/{goodsSeq}/form/upload/images/thumb", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<List<Map<String, Object>>> goodsThumnailImagesUpload(@PathVariable int goodsSeq, @RequestBody MultipartFile[] uploadFile, HttpServletRequest request){
		GoodsThumbNailVO thumbVO = new GoodsThumbNailVO();
		String memberId = (String)request.getSession().getAttribute("memberId");
		thumbVO.setReguser(memberId);
		thumbVO.setGoods_seq(goodsSeq);

		List<Map<String, Object>> thumbList = goodsService.insertThumbnail(uploadFile, thumbVO);
		
		return new ResponseEntity<>(thumbList, HttpStatus.OK);
	}
	
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
