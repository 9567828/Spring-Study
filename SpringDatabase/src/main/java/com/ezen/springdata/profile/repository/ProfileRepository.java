package com.ezen.springdata.profile.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.profile.dto.ProfileImgDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// db에 접근하는 소스코드!
@Repository
public class ProfileRepository {
	private final SqlSessionTemplate sql;
	
	public void saveProfileImg(ProfileImgDTO profileImgDTO) {
		sql.insert("Profile.saveProfileImg", profileImgDTO);
	}
}
