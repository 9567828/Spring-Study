package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springmvc.dto.Student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController2 {
	
	@GetMapping("/test2/page1")
	public String page1(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getMethod());
		System.out.println(req.getServletContext());
		System.out.println(req.getSession());
		
		req.setAttribute("coffee", "아메리카노");
		
		return "/test2/page1";
	}
	
	@GetMapping("/test2/stu")
	public String stuForm() {
		return "/test2/stuForm";
	}
	
	@PostMapping("/test2/stu")
	public String stu(Student stu, HttpServletRequest req) {
		
		// 모델 객체를 활용하면 request.getParameter()작업을 생략할 수 잇다
		// (단, 필드 이름과 name 속성값이 동일해야 한다)
		
		// jsp에서 원래 했던 작업
		// stu = new Student();
		// stu.setStu_name(request.getParameter("stu_name")
		
		System.out.println(stu);
		
		req.setAttribute("stu", stu);
		
		return "/test2/stuDetail";
	}
	
}
