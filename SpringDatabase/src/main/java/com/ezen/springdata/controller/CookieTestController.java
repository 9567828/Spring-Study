package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/cookie")
@Slf4j
@Controller
public class CookieTestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletResponse resp) {
		resp.addCookie(new Cookie("uid", "1234"));
		resp.addCookie(new Cookie("fid", "adfwege"));
		resp.addCookie(new Cookie("cid", "agege"));
		
		Cookie pidCookie = new Cookie("pid", "4321");
		
		pidCookie.setMaxAge(300);
		pidCookie.setHttpOnly(true); // 자바스크립트 쪽에서 사용하지 못하는 쿠키가 된다
		
		resp.addCookie(pidCookie);
		
		return "/cookie/index";
	}
	
	@GetMapping("/test2")
	public String test2(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		
		log.info("### 모든 쿠키 출력하기 ###");
		for (Cookie cookie : cookies) {
			log.info("{}={}", cookie.getName(), cookie.getValue());
		}
		
		return "/cookie/index";
	}

	// 간편하게 꺼내는 방법
	@GetMapping("/test3")
	public String test3(@CookieValue(name = "uid", required = true) Cookie uidCookie) {
		
		log.info("test3에서 받은 쿠기: {}={}", uidCookie.getName(), uidCookie.getValue());
		
		return "/cookie/index";
	}
	
	
}
