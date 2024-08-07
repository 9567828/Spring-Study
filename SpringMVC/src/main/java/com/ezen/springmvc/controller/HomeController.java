package com.ezen.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.springmvc.dto.CoffeeDTO;

@Controller
public class HomeController {
	
	// 이 클래스에서 발생하는 모든 로그들을 수집하는 객체
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	@GetMapping("/lombok")
	public String lombok() {
		CoffeeDTO coffeeDto = new CoffeeDTO();
		
		coffeeDto.setCoffee_eng_name("Americano");
		coffeeDto.setCoffee_kor_name("아메리카노");
		coffeeDto.setCoffee_price(1500);
		
//		System.out.println(coffeeDto);
		log.trace("{}", coffeeDto);
		
		CoffeeDTO coffee1 = new CoffeeDTO("믹스커피", "mixed", 500);
		CoffeeDTO coffee2 = new CoffeeDTO("믹스 커피", "mixed", 500);
		CoffeeDTO coffee3 = new CoffeeDTO("믹스 커피", "mixed", 500);

		// 해퀴코드는 같은 값을 넣었을 때 같은 결과가 나오는 코드이다
//		System.out.println("coffee1의 모든 값을 통해 도출해낸 해쉬코드값: " + coffee1.hashCode());
//		System.out.println("coffee2의 해쉬코드값: " + coffee2.hashCode());
//		System.out.println("coffee3의 해쉬코드값: " + coffee3.hashCode());
		
		log.info("coffee1의 모든 값을 통해 도출해낸 해쉬코드값: {}", coffee1.hashCode());
		log.info("coffee2 해쉬코드값: {}", coffee2.hashCode());
		log.info("coffee3 해쉬코드값: {}", coffee3.hashCode());
		
		// Lombok이 구현해주는 equals()는 두 객체의 hashCode()가 일치할 때 true를 반환한다.
//		System.out.println("coffee1, coffee2의 해쉬코드가 다르므로 다른 객체: " + coffee1.equals(coffee2));
//		System.out.println("coffee2, coffee3의 해쉬코드가 같으므로 다른 객체: " + coffee2.equals(coffee3));
		
		log.error("coffee1, coffee2의 해쉬코드가 다르므로 다른 객체: {}", coffee1.equals(coffee2));
		log.error("coffee2, coffee3의 해쉬코드가 같다: {}", coffee2.equals(coffee3));
		
		return "index";
	}

}
