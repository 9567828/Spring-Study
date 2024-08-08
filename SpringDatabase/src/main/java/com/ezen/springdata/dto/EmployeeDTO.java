package com.ezen.springdata.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private double salary;
	private double commission_pct;
	private Integer manager_id;
	private Integer department_id;
}
