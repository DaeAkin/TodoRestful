package com.todo.restful.service;

import java.util.Map;

import com.todo.restful.dto.MemberDto;

public interface LoginService {
	
	public MemberDto login(Map<String, Object> paramMap);
	
	public int memberAdd(Map<String, Object> paramMap);
	
	public void deleteAllMember();

}
