package com.ezen.springdata.profile.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.springdata.profile.dto.ProfileImgDTO;
import com.ezen.springdata.profile.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileService {
	
	private final ProfileRepository profileRepository;
	
	public void save(ProfileImgDTO profileImgDTO) throws IllegalStateException, IOException {
		// 1. 클라이언트로 부터 전달 받은 파일을 서버 컴퓨터에 내보내기
		MultipartFile profileImageFile = profileImgDTO.getProfileImageFile();
		
		String originalFileName = profileImageFile.getOriginalFilename();
		String storedFileName = String.format("%s-%s", System.currentTimeMillis(), originalFileName);
		
		log.info("## 내보내야 하는 첨부받은 파일정보 ##");
		log.info("profileImgFile: {}", profileImageFile);
		log.info("originalFilename: {}", originalFileName);
		log.info("storedFilename: {}", storedFileName);
		
		String savePath = "D:/spring_upload_files/" + storedFileName;
		profileImageFile.transferTo(new File(savePath));
		
		// 2. 서버 컴퓨터에 파일 쓰기를 성공했다면 DB에 내용을 반영
		profileImgDTO.setOriginalFileName(originalFileName);
		profileImgDTO.setStoredFileName(storedFileName);
		profileRepository.saveProfileImg(profileImgDTO);
	}
}
