package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.bean.MemberBean;
import com.my.service.SessionService;

@Controller
public class SessionController {
	
	private static Logger log = LoggerFactory.getLogger(SessionController.class);
	
	
	
	@Autowired
	private SessionService sessionService;
	
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginGet() {
		System.out.println("login GET");
		
		return "redirect:/";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(MemberBean m, Model model, HttpServletRequest request) {
		System.out.println("login POST");		
		
		m.setMem_id(request.getParameter("mem_id")); 
		m.setmem_password(request.getParameter("mem_password"));		
		String id = m.getMem_id();
		String pw = m.getmem_password();
		
		MemberBean bean = sessionService.idCheck(id);		//입력 값으로 DB조회
		
		if(bean == null) {									//아이디 틀릴경우
			String error = "아이디를 확인해주세요.";			
			model.addAttribute("error", error);			
			return "login/loginform";
		}
		if(!pw.equals(bean.getmem_password())) {			//비밀번호 틀릴 경우
			System.out.println("비밀번호 확인 부탁");
			String error = "비밀번호를 확인해주세요.";
			model.addAttribute("error", error);			
			return "login/loginform";
		}
		
		int mem_num = bean.getMem_num();
		System.out.println("로그인 기록 남기자");
		sessionService.loginHistory(mem_num);				//로그인 기록 남기기
		
		return "main/main";
	}
	
	@RequestMapping(value = "singUp")
	public String singUp(Model model) {
		return "session/singUp";
	}
	
	@RequestMapping(value = "joinUpComplete", method=RequestMethod.POST)
	public String joinUpComplete(MemberBean m, @RequestParam(defaultValue="설명이 비어있습니다.") String member_context ,
			Model model, HttpServletRequest request) {			//singUp.jsp 파일의 name 속성을 받아옴
		
		System.out.println("m : " + m);
		
		sessionService.join(m);
		
		return "session/joinUpComplete";
	}	
	
	@RequestMapping(value = "checkId")
	@ResponseBody
	public boolean checkId(HttpServletRequest request, Model model) {
		System.out.println("checkId Controller 들어옴");
		boolean rs = false; 
		String id = request.getParameter("id");
		
		MemberBean bean = sessionService.idCheck(id);
		if(bean==null) {										//사용할 수 있는 아이디라면
			rs = true;
			System.out.println("사용가능 아이디");
		}
		
		System.out.println("리턴 직전");
		return rs;
	}

	@RequestMapping(value = "checkNick")
	@ResponseBody
	public boolean checkNick(HttpServletRequest request, Model model) {
		System.out.println("checkNick Controller 들어옴");		
		boolean rs = false; 
		String nick = request.getParameter("nick");
		
		MemberBean bean = sessionService.nickCheck(nick);
		if(bean==null) {										//사용할 수 있는 닉네임라면
			rs = true;
			System.out.println("사용가능 닉네임");
		}
		
		System.out.println("리턴 직전");
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
