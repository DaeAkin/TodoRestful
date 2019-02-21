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
	public int deleteOneTodoWithTodono(int todo_no) {
		// TODO Auto-generated method stub
		return todoDao.deleteOneTodoWithTodono(todo_no);
	}

	@Override
	public int updateTodo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return todoDao.updateTodo(paramMap);
	}

	@Override
	public TodoDto selectOneTodoWithtodono(int todo_no) {
		// TODO Auto-generated method stub
		return todoDao.selectOneTodoWithtodono(todo_no);
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

	@Override
	public List<TodoDto> selectAllTodoWithIdno(int id_no) {
		// TODO Auto-generated method stub
		return todoDao.selectAllTodoWithIdno(id_no);
	}

	@Override
	public int toggleComplete(Map<String, Object> paramMap) {
		
		boolean iscompleted = (Boolean)paramMap.get("iscompleted");
	
		
		iscompleted = iscompleted ? false : true;
		
		paramMap.put("iscompleted", iscompleted);
		

	
		
		return todoDao.toggleComplete(paramMap);
		
	}
	

}
