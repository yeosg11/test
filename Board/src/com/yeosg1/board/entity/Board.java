package com.yeosg1.board.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yeosg1.board.common.BoardIndex;

// 게시물 번호/ 제목 /내용 /작성일 /[작성자 이메일]/ 작성자닉네임 /작성자 프로필사진/ 
// 댓글 수/ 좋아요 수/ 조회 수/ 게시물 이미지(여러 개)
// / 좋아요한 사용자의 프로필 사진 / 좋아요한 사용자의 닉네임/
// 댓글 작성자의 프로필 사진/[좋아요한 사용자의이메일]/ 댓글 작성자의 닉네임 / 댓글 작성 시간/ 댓글 내용
 
public class Board {

	private int boardNumber;
	private String title;
	private String contents;
	private String writeDatetime;
	private String writerEmail;
	private String writerNickname;
	private String writerProfileImage;

	private int viewCount;
	private List<String> imageList;
	private List<Liky> likeList;
	private List<Comment> commentList;

	public Board(String title, String contents, String writerEmail, String writerNickname, String writerProfileImage,
			List<String> imageList) {
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd. hh:mm:ss");
		
		this.boardNumber = BoardIndex.index++;
		this.title = title;
		this.contents = contents;
		this.writeDatetime = simpleDateFormat.format(now);
		this.writerEmail = writerEmail;
		this.writerNickname = writerNickname;
		this.writerProfileImage = writerProfileImage;
		this.viewCount = 0;
		this.imageList = imageList;
		this.likeList = new ArrayList<Liky>();
		this.commentList = new ArrayList<Comment>();
		
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public String getWriterProfileImage() {
		return writerProfileImage;
	}

	public void setWriterProfileImage(String writerProfileImage) {
		this.writerProfileImage = writerProfileImage;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public List<Liky> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Liky> likeList) {
		this.likeList = likeList;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getWriteDatetime() {
		return writeDatetime;
	}

	public String getWriterEmail() {
		return writerEmail;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}
	
 	
	
	
	
}
