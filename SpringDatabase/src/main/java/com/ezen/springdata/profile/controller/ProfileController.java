package com.ezen.springdata.profile.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdata.profile.dto.ProfileImgDTO;
import com.ezen.springdata.profile.service.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class ProfileController {
	
	private final ProfileService profileService;
	
	@GetMapping("/profile/image/upload")
	public String profileImgeUploadPage(ProfileImgDTO profileImgDTO) {
		
		
		return "/profile/upload_img";
	}
	
	@PostMapping("/profile/image/save")
	public String profileImgSave(ProfileImgDTO profileImgDTO) {
		
		log.info("profileImgDTO = {}", profileImgDTO);
		try {
			profileService.save(profileImgDTO);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/profile/image/upload";
	}
	
}
