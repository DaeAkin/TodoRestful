package com.todo.restful.dao;

import java.util.List;
import java.util.Map;

import com.todo.restful.dto.TodoDto;

public interface TodoDao {
	
	int addTodo(Map<String, Object> paramMap);
	
	int deleteOneTodo(Map<String, Object> paramMap);
	
	int updateTodo(Map<String, Object> paramMap);
	
	TodoDto selectOneTodo(Map<String, Object> paramMap);
	
	List<TodoDto> selectAllTodo();
	
	void deleteAllTodo();

}
