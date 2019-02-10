package com.todo.restful.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.todo.restful.dto.TodoDto;

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("addTodo", paramMap);
	}

	@Override
	public int deleteOneTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.delete("deleteOneTodo",paramMap);
	}

	@Override
	public int updateTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateTodo");
	}

	@Override
	public TodoDto selectOneTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectOneTodo", paramMap);
	}

	@Override
	public List<TodoDto> selectAllTodo() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectAllTodo");
	}

	@Override
	public void deleteAllTodo() {
		sqlSession.delete("deleteAllTodo");
		
	}
}
