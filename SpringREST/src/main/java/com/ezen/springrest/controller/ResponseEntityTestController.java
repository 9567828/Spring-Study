package com.ezen.springrest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.FruitDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/entity")
@RestController
public class ResponseEntityTestController {
	
	// 응답하는 ResponseEntity의 제네릭은 (body)에 들어가는 데이터의 타입을 의미한다
	@GetMapping("/test1")
	public ResponseEntity<String> test1() {
		// 원하는 응답 인스턴스 생성하기 (스테틱 메서드를 활용)
		// 응답은 메서드 체이닝 방식을 통해 생성한다
		return ResponseEntity
				.status(404)
				.contentType(MediaType.TEXT_HTML)
				.body("<html>"
						+ "<head>"
						+ "<meta charset=\"UTF-8\">"
						+ "<title>수제응답 생성하기</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>내가 만든 html</h1>"
						+ "</body>"
						+ "</html>");
	}
	
	
	// jackson-databind가 ResponseEntity의 body 내용도 JSON 형식으로 변환해 준다
	@GetMapping("/test2")
	public ResponseEntity<FruitDTO> test2() {
		FruitDTO fruit = new FruitDTO();
		
		fruit.setFid(33);
		fruit.setFname("사과");
		fruit.setPrice(3500);
		fruit.setQty(50);
		fruit.setLocation_id(1800);
		
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(fruit);
	}
	
	@PatchMapping("/test3")
	public ResponseEntity<String> test3(FruitDTO fruitDTO) {
		log.info("fruitDTO: {}", fruitDTO);
		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("오키!");
	}
}
