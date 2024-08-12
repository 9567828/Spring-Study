package com.ezen.springdata.fruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdata.fruit.service.FruitOrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// final을 쓸라면 아래 어노테이션을 넣어야 한다
@RequiredArgsConstructor
// 로그백 쓸 때
@Slf4j
@Controller
public class FruitOrderController {
	
	private final FruitOrderService fruitOrderServie;
	
	@GetMapping("/fruitorder/list")
	public String list(Model model) {
		model.addAttribute("fruitOrders", fruitOrderServie.list());
		model.addAttribute("fruitSalesList", fruitOrderServie.getSaleList());
		
		return "fruitorder/list";
	}
	
	// 이름(매개변수)를 다르게 하려면 @requestparam()으로 수정해주도록 한다
	@PostMapping("/fruitorder/sale")
	public String sale(Integer fid, Integer qty) {
		fruitOrderServie.saleFruit(fid, qty);
		
		return "redirect:/fruitorder/list";
	}
	
}
