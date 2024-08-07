package com.ezen.springmvc.cook;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Hotel {
	private String name;
	private String addr;
	private String tel;
	private Integer grade;
}
