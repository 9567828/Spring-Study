package com.ezen.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.cook.Cook;
import com.ezen.springmvc.cook.LombokCook;

@RequestMapping("/component")
@Controller
public class ComponentScanController {
	
	@Autowired
	Cook cook;
	@Autowired
	LombokCook lombokcook;
	
	@GetMapping("/test1")
	public String test1() {
		System.out.println("cook:" + cook);
		System.out.println("lombokcook:" + lombokcook);
		return "index";
	}
	
}
