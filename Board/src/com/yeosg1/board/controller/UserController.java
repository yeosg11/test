package com.yeosg1.board.controller;


import com.yeosg1.board.dto.request.SignInRequestDto;
import com.yeosg1.board.dto.response.ResponseEntity;
import com.yeosg1.board.dto.response.SignInResponseDto;
import com.yeosg1.board.dto.response.SignUpRequestDto;
import com.yeosg1.board.dto.response.SignUpResponseDto;

public interface UserController {
	ResponseEntity<SignUpResponseDto> signUp (SignUpRequestDto requstDto);
	ResponseEntity<SignInResponseDto> signIn (SignInRequestDto requstDto);
	
}

// ResponseDto : 	   int status, String message
// SignInResponseDto : int status, String message, String email, String nickname, String ...





