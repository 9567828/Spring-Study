package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test3")
@Controller
public class TestController3 {
	
	@GetMapping("/p1")
	public String page1() {
		return "/test3/page1";
	}
	
	@GetMapping("/p2")
	public void page2() {
		// 컨트롤러의 메서드가 void 타입인 경우
		// 이곳에 접속하기 위해 필요했던 요청 uri를 그대로
		// 다음 view를 찾기 위한 경로로 사용한다
	}
	
	@GetMapping("/p3")
	public ModelAndView page() {
		ModelAndView mnv = new ModelAndView();
		
		// 다음으로 가야할 뷰를 설정
		mnv.addObject("fruit", "복숭아");
		mnv.setViewName("/test3/page3");
		return mnv;
	}
}
