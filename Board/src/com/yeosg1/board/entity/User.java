package com.yeosg1.board.entity;

import com.yeosg1.board.dto.response.SignUpRequestDto;

// 이메일/ 비밀번호/ 닉네임/ 휴대전화번호/ 주소/ 상세주소/ 개인정보동의 여부/프로필 사진
public class User {

	private String email;
	private String password;
	private String nickname;
	private String telNumber;
	private String address;
	private String addressDetail;
	private boolean agreePersonal;
	private String profileImage;
	
	//
	
	public User(String email, String passowrd, String nickname, String telNumber, String address, String addressDetail,
			boolean agreePersonal) {
		this.email = email;
		this.password = passowrd;
		this.nickname = nickname;
		this.telNumber = telNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.agreePersonal = agreePersonal;
	}


	public User(SignUpRequestDto dto) {
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.nickname = dto.getNickname();
		this.telNumber = dto.getTelNumber();
		this.address = dto.getAddress();
		this.addressDetail = dto.getAddressDetail();
		this.agreePersonal = dto.isAgreedPersonal();
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getTelNumber() {
		return telNumber;
	}


	public String getAddress() {
		return address;
	}


	public String getAddressDetail() {
		return addressDetail;
	}


	public boolean isAgreePersonal() {
		return agreePersonal;
	}


	public boolean isCreateValid() {
		if (email == null || password == null ||
				nickname == null || telNumber == null || address == null) {
			return false;	
		}
		if(email.isBlank() || password.isBlank() ||
			 nickname.isBlank() || telNumber.isBlank() ||
			 address.isBlank() || !agreePersonal) {
		return false;
		
		}
		return true;
	}
	
	public static void main(String[] args) {
		

	}

}
