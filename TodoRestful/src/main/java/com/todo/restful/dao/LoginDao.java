package com.todo.restful.dao;

import java.util.Map;

import com.todo.restful.dto.MemberDto;

public interface LoginDao {
	
	public MemberDto login(Map<String, Object> paramMap);
	
	public int memberAdd(Map<String, Object> paramMap);
	
	public void deleteAllMember();

}
