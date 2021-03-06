package com.goott.eco.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.goott.eco.common.Criteria;
import com.goott.eco.domain.AttachFileDTO;
import com.goott.eco.service.CommonService;
import com.goott.eco.service.GoodsService;

@RequestMapping("/goods")
@Controller
public class GoodsController {
	
	@Autowired private GoodsService goodsService;
	@Autowired private CommonService commonService;
	
	@GetMapping("")
	public ModelAndView goodsList(HttpServletRequest request, HttpServletResponse response, Criteria cri) {
		ModelAndView mav = new ModelAndView("/goods/goods_list");
//		mav.addAllObjects(goodsService.goodsList(cri));
		mav.addObject("cateList", commonService.categoryList());
		mav.addObject("cri", cri);
		
		return mav;
	}
	
	@GetMapping("/{goodsSeq}")
	public ModelAndView goodsDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable int goodsSeq) {
		ModelAndView mav = new ModelAndView("/goods/goods_detail");
		mav.addAllObjects(goodsService.goodsDetail(goodsSeq));
		
		return mav;
	}
	
	@GetMapping("/form")
	public ModelAndView goodsInsert() {
		ModelAndView mav = new ModelAndView("company/goods_insert");
		mav.addObject("cateList", commonService.categoryList());
		return mav;
	}
	
	//?????????...
	@PostMapping(value="/form/upload/images")//, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public String goodsDetailImagesUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
//			out.println("NOTALLOW_"+filename);
			System.out.println("NOTALLOW");
		} else {
			//?????????????????? ?????? ????????? ???????????? ?????? ??? ?????????	
			//?????? ????????????
//			String dftFilePath = request.getServletContext().getRealPath("/");
			String dftFilePath = "c:\\upload\\temp\\";
			//?????? ???????????? _ ????????????
			String filePath = dftFilePath + "editor" + File.separator +"multiupload" + File.separator;
			File file = new File(filePath);
			
			if(!file.exists()) { file.mkdirs(); }
			
			String realFileNm = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today= formatter.format(new java.util.Date());
			realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			rlFileNm = filePath + realFileNm;
			///////////////// ????????? ???????????? ///////////////// 
			InputStream is = request.getInputStream();
			OutputStream os=new FileOutputStream(rlFileNm);
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
//			sFileInfo += "&sFileURL=" + "/editor/multiupload/" + realFileNm;
			sFileInfo += "&sFileURL=" + "/upload/img/editor/multiupload/" + realFileNm;
		}
		return sFileInfo;
	}
	
		@GetMapping(value="/form/upload/images/thumb")//, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
		public String goodsThumbnailImagesUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
			return "goods/thumb_upload";
		}
}