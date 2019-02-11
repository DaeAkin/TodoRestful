package com.todo.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="test2")
	public void test2(@RequestBody Map<String, Object> paramMap,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("loginSession", 1234);
	}

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

}
