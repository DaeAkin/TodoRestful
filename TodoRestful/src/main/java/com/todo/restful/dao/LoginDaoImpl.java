package com.todo.restful.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.restful.dto.MemberDto;
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("login", paramMap);
	}

	@Override
	public int memberAdd(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberAdd", paramMap);
	}

	@Override
	public void deleteAllMember() {
		sqlSession.delete("deleteAllMember");
		
	}

}
