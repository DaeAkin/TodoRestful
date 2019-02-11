package com.todo.restful.dao;

import java.util.List;
import java.util.Map;

import com.todo.restful.dto.TodoDto;

public interface TodoDao {
	
	int addTodo(Map<String, Object> paramMap);
	
	int deleteOneTodoWithTodono(int todo_no);
	
	int updateTodo(Map<String, Object> paramMap);
	
	TodoDto selectOneTodoWithtodono(int todo_no);
	
	List<TodoDto> selectAllTodo();
	
	void deleteAllTodo();

	List<TodoDto> selectAllTodoWithIdno(int id_no);
}
