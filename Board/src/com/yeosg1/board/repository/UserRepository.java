package com.yeosg1.board.repository;


import java.util.ArrayList;
import java.util.List;

import com.yeosg1.board.entity.User;

public interface UserRepository extends Repository<User, String> {
	
	// 유저 정보를 저장할 User Entity List

	public static final List<User> USERS = new ArrayList<User>();

	public abstract boolean existsByEmail(String email);
	public abstract boolean existsByTelNumber(String telNumber);
	public abstract boolean existsByNickname(String nickname);

}
