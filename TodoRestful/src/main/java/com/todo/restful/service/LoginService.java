package com.todo.restful.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.todo.restful.dto.MemberDto;

@Transactional
public interface LoginService {
	@Transactional(readOnly=true)
	public MemberDto login(Map<String, Object> paramMap);
	
	public int memberAdd(Map<String, Object> paramMap);
	
	public void deleteAllMember();

}
