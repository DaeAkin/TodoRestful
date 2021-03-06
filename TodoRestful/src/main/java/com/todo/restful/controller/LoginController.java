package com.todo.restful.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restful.dto.MemberDto;
import com.todo.restful.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/test" , method = RequestMethod.POST)
	public Map<String,Object> test() {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		System.out.println(" ---- test ----");
		returnMap.put("test", true);
		
		return returnMap;
		
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public Map<String, Object> doLogin(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request) {
		// 리턴할 json 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		HttpSession session = request.getSession();
		
		
		System.out.println("---- 로그인한 사람 :" + paramMap.get("id") + " ----" );
		
		
		MemberDto memberDto = 
				loginService.login(paramMap);
		
		if(memberDto == null) {
			resultMap.put("isLogined", false);
		} else {
			resultMap.put("isLogined", true);
			session.setAttribute("loginSession", memberDto);
		}
		
		
		
		return resultMap;
	}

}
