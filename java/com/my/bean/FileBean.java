package com.my.bean;

import org.springframework.web.multipart.MultipartFile;

public class FileBean {
	private int file_num;
	private String file_name, file_name_clone;
	private MultipartFile multiFile;
	
	
	public FileBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FileBean(int file_num, String file_name, String file_name_clone, MultipartFile multiFile) {
		super();
		this.file_num = file_num;
		this.file_name = file_name;
		this.file_name_clone = file_name_clone;
		this.multiFile = multiFile;
	}


	public int getFile_num() {
		return file_num;
	}


	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}


	public String getFile_name() {
		return file_name;
	}


	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}


	public String getFile_name_clone() {
		return file_name_clone;
	}


	public void setFile_name_clone(String file_name_clone) {
		this.file_name_clone = file_name_clone;
	}


	public MultipartFile getMultiFile() {
		return multiFile;
	}


	public void setMultiFile(MultipartFile multiFile) {
		this.multiFile = multiFile;
	}


	@Override
	public String toString() {
		return "FileBean [file_num=" + file_num + ", file_name=" + file_name + ", file_name_clone=" + file_name_clone
				+ ", multiFile=" + multiFile + "]";
	}
	
	

	
	
}
