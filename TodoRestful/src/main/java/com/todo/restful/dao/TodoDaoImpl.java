package com.todo.restful.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public int deleteOneTodoWithTodono(int todo_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete("deleteOneTodo",todo_no);
	}

	@Override
	public int updateTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateTodo",paramMap);
	}

	@Override
	public TodoDto selectOneTodoWithtodono(int todo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectOneTodoWithtodono", todo_no);
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

	@Override
	public List<TodoDto> selectAllTodoWithIdno(int id_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectAllTodoWithIdno", id_no);
	}

	@Override
	public int toggleComplete(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub		
		return sqlSession.update("toggleComplete",paramMap);
	}
}
