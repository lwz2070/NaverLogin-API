package com.my.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bean.MemberBean;

@Service
public class SessionService {
	
	@Autowired
	private SqlSession sqlSession;
	

	public List<MemberBean> memberList() {
		List<MemberBean> list = sqlSession.selectList("sessionSQL.memberList");
		return list;
	}
	
	public MemberBean idCheck(String id) {
		MemberBean bean = sqlSession.selectOne("sessionSQL.idCheck", id); 
		return bean;
	}
	
	public MemberBean nickCheck(String nick) {
		MemberBean bean = sqlSession.selectOne("sessionSQL.nickCheck", nick); 
		return bean;
	}
	
	public void join(MemberBean bean) {
		sqlSession.insert("sessionSQL.join", bean);
	}
	
	
	public void loginHistory(int mem_num) {
		sqlSession.insert("sessionSQL.loginHistory", mem_num);
	}
	
}
