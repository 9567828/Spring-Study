package com.ezen.springdata.fruit.repository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.FruitDTO;
import com.ezen.springdata.dto.FruitSalesHistoryDTO;

import lombok.RequiredArgsConstructor;

// Autowired 걸어주기
@RequiredArgsConstructor
@Repository
public class FruitOrderRepository {
	
	private final SqlSessionTemplate sql;
	
	public List<FruitDTO> getAll() {
		return sql.selectList("Fruits.getAll");
	}
	
	// qty가 0개 일 때 판매를 클릭하면 제약조건 위배 exception이 발생하도록 throws를 넣는다
	public boolean reduceFruit(Integer fid, Integer qty) throws SQLIntegrityConstraintViolationException {
		HashMap<String, Object> paraMap = new HashMap<>(); 
		
		paraMap.put("fid", fid);
		paraMap.put("qty", qty);
		
		return sql.update("Fruits.reduceFruit", paraMap) > 0;
	}
	
	public boolean addHistory(Integer fid, Integer qty) {
		HashMap<String, Object> paraMap = new HashMap<>(); 
		
		paraMap.put("fid", fid);
		paraMap.put("qty", qty);
		
		return sql.insert("Fruits.addHistory", paraMap) > 0;
	}
	
	public List<FruitSalesHistoryDTO> getSalesList() {
		return sql.selectList("Fruits.getSalesList");
	}

}
