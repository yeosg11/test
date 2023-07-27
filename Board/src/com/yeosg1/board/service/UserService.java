package com.yeosg1.board.service;

import com.yeosg1.board.dto.request.SignInRequestDto;
import com.yeosg1.board.dto.response.ResponseEntity;
import com.yeosg1.board.dto.response.SignInResponseDto;
import com.yeosg1.board.dto.response.SignUpRequestDto;
import com.yeosg1.board.dto.response.SignUpResponseDto;


public interface UserService {
	ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto);
	ResponseEntity<SignInResponseDto> signIn(SignInRequestDto dto);
	
}
