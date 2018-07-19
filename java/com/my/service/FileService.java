package com.my.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bean.FileBean;

@Service
public class FileService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void fileUpload(FileBean bean) {
		sqlSession.insert("fileSQL.fileUpload", bean);
	}
	
	public List<FileBean> fileList() {
		List<FileBean> bean = sqlSession.selectList("fileSQL.fileList");
		
		return bean;
	}
	
	public FileBean fileInfo(String num1) {
		int num = Integer.parseInt(num1);
		FileBean bean = sqlSession.selectOne("fileSQL.fileInfo", num);
		
		return bean;
	}
}
