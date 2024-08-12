package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springdata.dto.FruitDTO;
import com.ezen.springdata.mapper.FruitsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/fruit")
@RequiredArgsConstructor
@Controller
public class FruitsTestController {
	private final FruitsRepository fruitsRepository;
	
	// @Slf4j 어노테이션으로 자동 생성 가능
	//private final static Logger log = LoggerFactory.getLogger(FruitsTestController.class);
	
	@GetMapping("/add")
	public String addFruitForm() {
		return "fruit/add_form";
	}
	
	@PostMapping("/add")
	public String addFruit(FruitDTO fruit) {
		log.info("{}", fruit);
		log.info("insert 결과: {}", fruitsRepository.add2(fruit));
		
		return "redirect:/fruit/add";
	}
	
	// 과일 목록 보기, 과일 삭제하기, 과일 정보 수정하기
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("fruitList", fruitsRepository.getList());
		return "fruit/list";
	}
	
	@GetMapping("/detail")
	public String getDetail(Integer fid, Model model) {
		model.addAttribute("fruitDetail", fruitsRepository.getDetail(fid));
		return "fruit/detail";
	}

	@PostMapping("/detail/{fid}")
	public String update(@PathVariable("fid") Integer fid, FruitDTO fruitDTO) {
	    fruitDTO.setFid(fid);
	    fruitsRepository.update(fruitDTO);
	    return "redirect:/fruit/detail?fid=" + fid;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("fid") Integer fid) {
	    fruitsRepository.delete(fid);
	    return "redirect:/fruit/list";
	}
}
