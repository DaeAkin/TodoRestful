package com.todo.restful.utils;

import java.util.HashMap;
import java.util.Map;

import com.todo.restful.dto.MemberDto;
import com.todo.restful.dto.TodoDto;

public class DtoToMap {
	
	public static Map<String,Object> 
	dtoToMemberDtoParam(MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("id", memberDto.getId());
		resultMap.put("pw", memberDto.getPw());
		
		return resultMap;
	
	}
	
	public static Map<String, Object>
		dtoToTodoDtoParam(TodoDto todoDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("todo_no", todoDto.getTodo_no());
		resultMap.put("id_no", todoDto.getId_no());
		resultMap.put("todo", todoDto.getTodo());
		resultMap.put("iscompleted", todoDto.getIscompleted());
		
		
		return resultMap;
	}

}
