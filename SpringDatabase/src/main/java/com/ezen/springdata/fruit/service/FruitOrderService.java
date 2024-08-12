package com.ezen.springdata.fruit.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.springdata.dto.FruitDTO;
import com.ezen.springdata.dto.FruitSalesHistoryDTO;
import com.ezen.springdata.fruit.repository.FruitOrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FruitOrderService {
	
	private final FruitOrderRepository fruitOrderRepository;
	
	public List<FruitDTO> list() {
		// DB에서 모든 주문 목록을 꺼내 와야 한다
		
		return fruitOrderRepository.getAll();
	}
	
	public void saleFruit(Integer fid, Integer qty) {
		// 1. 과일의 개수를 차감한다
		// try 문으로 로그 남기려는 시도 였으나 안됨
		try {
			fruitOrderRepository.reduceFruit(fid, qty);
		} catch (SQLIntegrityConstraintViolationException e) {
			log.info("해당 물품은 더 이상 판매할 수 없습니다.");
			
			return;
		}
		
		// 2. 판매 내역 테이블에 판매 정보행을 추가한다
		fruitOrderRepository.addHistory(fid, qty);
		
		// 3. 회원이었다면 구매액에 비례하여 마일리지 포인트를 증가시킨다
	}
	
	public List<FruitSalesHistoryDTO> getSaleList() {
		return fruitOrderRepository.getSalesList();
	}
	
	
}
