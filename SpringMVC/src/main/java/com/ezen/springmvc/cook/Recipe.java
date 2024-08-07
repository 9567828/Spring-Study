package com.ezen.springmvc.cook;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Recipe {
	private String food_name;
	private String[] gradients;
	private String[] cooking_process;

}
