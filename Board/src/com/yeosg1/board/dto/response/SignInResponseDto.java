package com.yeosg1.board.dto.response;

import com.yeosg1.board.entity.User;

public class SignInResponseDto {
	
	private String email;
	private String nickname;
	private String profileImage;
	
	public SignInResponseDto (User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.profileImage = user.getProfileImage();
		
		
	}

}
