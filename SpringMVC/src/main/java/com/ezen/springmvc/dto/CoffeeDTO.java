package com.ezen.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CoffeeDTO {
	// null이면 안되는 필드다~
	@NonNull
	private String coffee_kor_name;
	@NonNull
	private String coffee_eng_name;
	private Integer coffee_price;
	
}
