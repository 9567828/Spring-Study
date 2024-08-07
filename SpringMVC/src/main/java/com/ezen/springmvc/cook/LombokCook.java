package com.ezen.springmvc.cook;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LombokCook {
	// 필드마다 @Autowired 또는 @NonNull을 붙이지 않아도
	// 해당 필드를 private final로 설정하게 되면 롬복의
	// @RequiredArgsConstructor가 해당 필드를 포함한 생성자를 만들게 된다
	private final Hotel hotel;
	private final Recipe recipe;
}
