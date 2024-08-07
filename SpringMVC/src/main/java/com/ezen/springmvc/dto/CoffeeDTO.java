package com.ezen.springmvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CoffeeDTO {
	private String coffee_kor_name;
	private String coffee_eng_name;
	private Integer coffee_price;
	
}
