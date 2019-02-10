package com.todo.restful.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.restful.dao.TodoDao;
import com.todo.restful.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDao todoDao;

	//CRUD
	@Override
	public int addTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return todoDao.addTodo(paramMap);
	}

	@Override
	public int deleteOneTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return todoDao.deleteOneTodo(paramMap);
	}

	@Override
	public int updateTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return todoDao.updateTodo(paramMap);
	}

	@Override
	public TodoDto selectOneTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return todoDao.selectOneTodo(paramMap);
	}

	@Override
	public List<TodoDto> selectAllTodo() {
		// TODO Auto-generated method stub
		return todoDao.selectAllTodo();
	}

	@Override
	public void deleteAllTodo() {
		// TODO Auto-generated method stub
		todoDao.deleteAllTodo();
		
	}
	

}
