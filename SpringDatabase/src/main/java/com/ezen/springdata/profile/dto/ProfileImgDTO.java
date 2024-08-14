package com.ezen.springdata.profile.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProfileImgDTO {
	private Integer id;
	private String originalFileName;
	private String storedFileName;
	// 스프링이 알아서 매핑해준다
	private MultipartFile profileImageFile;
	private List<MultipartFile> profileImageFiles;
}
