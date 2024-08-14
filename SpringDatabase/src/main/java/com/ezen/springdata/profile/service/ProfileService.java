package com.ezen.springdata.profile.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
		
//		if (profileImageFile == null) {
//			return;
//		}
		
		saveFile(profileImageFile);
	}
	
	public void multisave(ProfileImgDTO profileImgDTO) throws IllegalStateException, IOException {
		List<MultipartFile> profileImgFiles = profileImgDTO.getProfileImageFiles();
		
		// 파일이 첨부된게 없으면 실행되지 않도록
//		if (profileImgFiles == null || profileImgFiles.size() == 0) {
//			return;
//		}
		
		
		for (MultipartFile profileImgFile : profileImgFiles) {
			log.info("multisave??: {}", profileImgFile);
			saveFile(profileImgFile);
		}
		
	}
	
	String rootPath = "D:/spring_upload_files/";
	
	private void saveFile(MultipartFile profileImageFile) throws IllegalStateException, IOException {
		
		if (profileImageFile == null || profileImageFile.isEmpty()) {
			return;
		}
		
		String originalFileName = profileImageFile.getOriginalFilename();
		String storedFileName = String.format("%s-%s", System.currentTimeMillis(), originalFileName);
		String savePath = rootPath + storedFileName;
		
		profileImageFile.transferTo(new File(savePath));
		
		ProfileImgDTO profileImgDTO = new ProfileImgDTO();
		
		// 2. 서버 컴퓨터에 파일 쓰기를 성공했다면 DB에 경로들을 보관
		profileImgDTO.setOriginalFileName(originalFileName);
		profileImgDTO.setStoredFileName(storedFileName);

		profileRepository.saveProfileImg(profileImgDTO);
	}
}
