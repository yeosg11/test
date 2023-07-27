package com.yeosg1.board.controller.implement;

import com.yeosg1.board.controller.UserController;
import com.yeosg1.board.dto.request.SignInRequestDto;
import com.yeosg1.board.dto.response.ResponseEntity;
import com.yeosg1.board.dto.response.SignInResponseDto;
import com.yeosg1.board.dto.response.SignUpRequestDto;
import com.yeosg1.board.dto.response.SignUpResponseDto;
import com.yeosg1.board.service.UserService;

public class UserControllerImplement implements UserController {

private final UserService userService ;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService ;
		
	}
	
	@Override
	public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto requestDto) {

		boolean isValid = requestDto.valid();
		if (!isValid) return ResponseEntity.badRequest();
		
		ResponseEntity<SignUpResponseDto> result = userService.signUp(requestDto);
		return result; 
	}

	@Override
	public ResponseEntity<SignInResponseDto> signIn(SignInRequestDto requestDto) {
		boolean isValid = requestDto.valid();
		if (!isValid) return ResponseEntity.badRequest();
		
		ResponseEntity<SignInResponseDto> result = userService.signIn(requestDto);
		return result; 
	}

}
