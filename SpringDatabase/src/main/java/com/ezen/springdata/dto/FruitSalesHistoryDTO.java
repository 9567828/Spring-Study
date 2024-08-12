package com.ezen.springdata.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FruitSalesHistoryDTO {
	private Integer fhid;
	private Integer fid;
	private Integer qty;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date purchase_time;
	
	@Autowired
	private FruitDTO fruit;
}
