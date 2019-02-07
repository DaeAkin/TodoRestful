package com.todo.restful.dto;

public class MemberDto {

	private int no;
	private String id;
	private String pw;
	
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int no,String id, String pw) {
		this.no = no;
		this.id = id;
		this.pw = pw;
	}
	
	public MemberDto(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
