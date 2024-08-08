package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdata.mapper.EmployeesMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/emp")
@Controller
public class EmployeesTestController {
	private final EmployeesMapper employeesMapper;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("empList", employeesMapper.getAll());
		
		return "emp/list";
	}
	
	@GetMapping("/detail")
	public String detail(Integer employee_id, Model model) {
		model.addAttribute("emp", employeesMapper.get(employee_id));
		return "emp/detail";
	}
	
	@GetMapping("/dept/{dept_id}")
	public String dept(@PathVariable("dept_id") Integer dept_id, Model model) {
		model.addAttribute("deptList", employeesMapper.getAllByDeptId(dept_id));
		
		return "emp/list";
	}
}
