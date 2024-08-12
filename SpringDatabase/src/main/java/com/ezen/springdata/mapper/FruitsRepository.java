package com.ezen.springdata.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.FruitDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FruitsRepository {
	private final SqlSessionTemplate sql;
	
	public boolean add(FruitDTO fruitDTO) {
		return sql.insert("Fruits.add", fruitDTO) > 0;
	}
	
	public FruitDTO add2(FruitDTO fruitDTO) {
		sql.insert("Fruits.add2", fruitDTO);
		return fruitDTO;
	}
	
	public List<FruitDTO> getList() {
		return sql.selectList("Fruits.getAll");
	}
	
	public FruitDTO getDetail(Integer fid) {
		return sql.selectOne("Fruits.get", fid);
	}
	
	public boolean update(FruitDTO furitDTO) {
		return sql.update("Fruits.editFruit", furitDTO) > 0;
	}
	
	public int delete(Integer fid) {
		return sql.delete("Fruits.deleteFruit", fid);
	}

}
