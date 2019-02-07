package com.todo.restful.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.restful.dao.LoginDao;
import com.todo.restful.dto.MemberDto;
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	@Override
	public MemberDto login(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return loginDao.login(paramMap);
	}

	@Override
	public int memberAdd(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return loginDao.memberAdd(paramMap);
	}

	@Override
	public void deleteAllMember() {
		// 
		loginDao.deleteAllMember();
	}

}
