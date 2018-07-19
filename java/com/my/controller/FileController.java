package com.my.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.my.bean.FileBean;
import com.my.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService FileService;
	
	public void setFileService(FileService FileService) {
		this.FileService = FileService;
	}
	
	@RequestMapping(value = "fileUpload", method = RequestMethod.POST )			
	public String fileUpload(FileBean bean, HttpServletRequest request) {			//File Upload
		System.out.println("fileUpload");
		
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		String[] chars = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
		for(int i = 0; i<20; i++) {
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		System.out.println("buffer = " + buffer);
		
		//업로드로 넘겨진 파일이 들어있는 빈을 multi에 넣음		
		MultipartFile multi =  bean.getMultiFile();			
		//MultipartFile이 가지고 있는 메소드 getOriginalFilename()으로 파일 이름 가져옴
		String originalFilename = multi.getOriginalFilename();		
		String cloneFilename = "";
		
		if (!originalFilename.equals("")) {		//파일이 있다면~
			cloneFilename = buffer + "_" + System.currentTimeMillis();		//확장자가 없는 clone 이름을 만듬
			
			//request.getSession().getServletContext().getRealPath("/")의 경로는 workspace/프로젝트 이름/src/main/webapp
			String root_path = request.getSession().getServletContext().getRealPath("/resources/upload/");
			System.out.println(root_path);
			String path = root_path + cloneFilename;
			bean.setFile_name(originalFilename);
			bean.setFile_name_clone(cloneFilename);
			
			try {
				File file = new File(path);
				multi.transferTo(file);					//내 컴퓨터의 paht경로에 clone 파일 추가.
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("디비 접근 직전");
			FileService.fileUpload(bean); 				//DB에 접근
		} 
		
		
		return "main/FileUpload";
	}
	
	@RequestMapping(value = "fileList")
	public String FileList(Model model) {			//File List 
		System.out.println("FileList");
		
		List<FileBean> bean = FileService.fileList();
		
		model.addAttribute("bean", bean);
		
		return "main/FileList";
	}
	
	@RequestMapping(value = "fileDown")
	@ResponseBody
	public void fileDown(HttpServletRequest request, HttpServletResponse response) throws IOException {			//File Download
		System.out.println("fileDown");
		
		String num = request.getParameter("num");
		System.out.println(num);
		
		FileBean bean = FileService.fileInfo(num);
		Gson gson = new Gson();
		String json = gson.toJson(bean);
		System.out.println(json);
		
		String root_path = request.getSession().getServletContext().getRealPath("/resources/upload/");
		String path = root_path + bean.getFile_name_clone();
		
		System.out.println(path);
		
        // MIME Type 을 application/octet-stream 타입으로 변경
        // 무조건 팝업(다운로드창)이 뜨게 된다.
        response.setContentType("application/octet-stream");
        // 파일명 지정
        response.setHeader("Content-Disposition", "attachment; filename=\""+ bean.getFile_name() +"\"");
        
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(root_path + File.separator + bean.getFile_name_clone());
        
        int n = 0;
        byte[] b = new byte[512];
        while((n = fis.read(b)) != -1 ) {
            os.write(b, 0, n);
        }
        fis.close();
        os.close();
        os.flush();
	}


}
