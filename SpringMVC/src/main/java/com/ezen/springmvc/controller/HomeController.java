package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.springmvc.dto.CoffeeDTO;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String index() {
		CoffeeDTO coffeeDto = new CoffeeDTO();
		
		coffeeDto.setCoffee_eng_name("Americano");
		coffeeDto.setCoffee_kor_name("아메리카노");
		coffeeDto.setCoffee_price(1500);
		
		System.out.println(coffeeDto);
		
		return "index";
	}

}
