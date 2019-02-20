package com.todo.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restful.dto.MemberDto;
import com.todo.restful.dto.TodoDto;
import com.todo.restful.exception.SessionInvalidException;
import com.todo.restful.service.TodoService;

@CrossOrigin
@RestController
public class TodoController {
	/* Todo 
	 * Session 인증 작업은 인터프리터나 프록시를 이용해서 
	 * Session 인증 할것.
	 */
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="test2")
	public void test2(@RequestBody Map<String, Object> paramMap,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("loginSession", 1234);
	}

	//해당 아이디에 관련된 todo를 가져오는 메소드
	@RequestMapping(value="/getAllTodo" , method = RequestMethod.GET)
	public Map<String, Object> getAllTodo(HttpServletRequest request) throws SessionInvalidException  {
		
		System.out.println("---- getAllTodo ----");
		//리턴할 json
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		
		MemberDto loginedMember =
				(MemberDto)session.getAttribute("loginSession");
		if(loginedMember == null ) {
			throw new SessionInvalidException("세션이 없거나 만료되었습니다.");
		}
		//로그인한 사람의 todo 찾기
		List<TodoDto> todos = 
				todoService.selectAllTodoWithIdno(loginedMember.getNo());
		
		resultMap.put("todos", todos);
		
		
		return resultMap;
	}
	
	//Todo 추가
	@RequestMapping(value="/addTodo" , method = RequestMethod.POST)
	public Map<String, Object> addTodo(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request) {
		System.out.println("---- addTodo ----");
		HttpSession session = request.getSession();
		
		MemberDto memberDto = (MemberDto)session.getAttribute("loginSession");
		paramMap.put("id_no", memberDto.getNo());
		paramMap.put("iscompleted", 0);
		
		// 리턴할 json 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 필터 단에서 body에 session 추가해주는 방법도 생각해보기. 
		
		int result = todoService.addTodo(paramMap);
		
		resultMap.put("result", result);
		
		return resultMap;
	}
	
	//Todo 업데이트 
	@RequestMapping(value="/updateTodo" , method = RequestMethod.GET)
	public Map<String, Object> updateTodo(@RequestBody Map<String, Object> paramMap) {
	
		Map<String, Object> resultMap = new HashMap<String, Object>();

		int result = todoService.updateTodo(paramMap);

		resultMap.put("result", result);

		return resultMap;
	}
	
	//Todo 삭제
	@RequestMapping(value="/deleteTodo/{deleted_id}" , method = RequestMethod.GET)
	public Map<String, Object> deleteTodo(@PathVariable(value="deleted_id") int todo_no) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		System.out.println("---- deleteTodo ----");
		
		int result = 
				todoService.deleteOneTodoWithTodono(todo_no);
		
	
		
		resultMap.put("result", result);
		
		System.out.println("result :" + result);
		
		return resultMap;
	}
	
	// 검색은 클라이언트에서 구현

}
