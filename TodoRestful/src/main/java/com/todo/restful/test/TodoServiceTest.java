package com.todo.restful.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todo.restful.dto.TodoDto;
import com.todo.restful.service.TodoService;
import com.todo.restful.utils.DtoToMap;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class TodoServiceTest {
	
	
	@Autowired
	TodoService todoService;
	
	TodoDto todo1;
	
	@Before
	public void setUp() {
		// 테스트할 id_no는 가변적이다.
		todo1 = new TodoDto(1, "스프링 공부하기 ", false);
	}
	
	@Test
	public void CURDTest() {
		todoService.deleteAllTodo();
		// todo 추가.
		todoService.addTodo(DtoToMap.dtoToTodoDtoParam(todo1));
		// 전체 todo 가져오기. 
		List<TodoDto> todoDtos = todoService.selectAllTodo();
		// 가져온 todo 갯수 확인
		assertThat(todoDtos.size(), is(1));
		// 넣은 todo 1개 가져와보기
		TodoDto resultTodo = todoService.selectOneTodoWithtodono(todoDtos.get(0).getTodo_no());
		// 가져온 todo 확인하기.
		assertThat(resultTodo.getTodo(), is(todo1.getTodo()));
		
		//update할 todo 객체
		TodoDto willUpdateTodo =
				new TodoDto(resultTodo.getTodo_no(),
							resultTodo.getId_no(),
							"리액트 공부하기", false);
		
		Map<String, Object> willUpdateMap = 
				DtoToMap.dtoToTodoDtoParam(willUpdateTodo);
		// todo_no도 넣어주기 
		willUpdateMap.put("todo_no", willUpdateTodo.getTodo_no());
		//update 하기 
		todoService.updateTodo(willUpdateMap);
		//update한 todo 확인
		assertThat(willUpdateTodo.getTodo(), 
				is(todoService.selectOneTodoWithtodono(
						willUpdateTodo.getTodo_no()).getTodo()));
		
		//삭제하기.
		todoService.deleteOneTodoWithTodono(willUpdateTodo.getTodo_no());
		
		assertThat(todoService.selectAllTodo().size(), is(0));
		
	}
	
	@Test
	public void selectAllTodoWithIdnoTest() {
		todoService.deleteAllTodo();
		// todo 추가.
		todoService.addTodo(DtoToMap.dtoToTodoDtoParam(todo1));
		// todo 추가.
		todoService.addTodo(DtoToMap.dtoToTodoDtoParam(todo1));
		// todo 추가.
		todoService.addTodo(DtoToMap.dtoToTodoDtoParam(todo1));
		
		assertThat(todoService.selectAllTodoWithIdno(todo1.getId_no()).size(),
				is(3));

	}

}
