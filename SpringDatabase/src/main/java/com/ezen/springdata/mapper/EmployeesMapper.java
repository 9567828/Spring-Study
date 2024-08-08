package com.ezen.springdata.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.EmployeeDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EmployeesMapper {
	private final SqlSessionTemplate sql;
	
	// seletList("namespace.id, parameter"): 여러 줄 select를 하는 쿼리문에 사용한다
	// mapper 파일에 설정한 이름을 전달해 Mapper에 정의된 쿼리문을 실행한다
	public List<EmployeeDTO> getAll() {	
		return sql.selectList("Employees.getAll");
	}
	
	// seletOne("namespace.id, parameter"): 한 줄 select를 하는 쿼리문에 사용한다 (주로 pk와 함께 사용)
	// mapper 파일에 설정한 이름을 전달해 Mapper에 정의된 쿼리문을 실행한다
	public EmployeeDTO get(Integer employee_id) {
		return sql.selectOne("Employees.get", employee_id);
	}
	
	public List<EmployeeDTO> getAllByDeptId(Integer dept_id) {
		return sql.selectList("Employees.getAllDeptById", dept_id);
	}
}
