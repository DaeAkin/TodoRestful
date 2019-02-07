package com.todo.restful.utils;

import java.util.HashMap;
import java.util.Map;

import com.todo.restful.dto.MemberDto;

public class DtoToMap {
	
	public static Map<String,Object> 
	dtoToMemberDtoParam(MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("id", memberDto.getId());
		resultMap.put("pw", memberDto.getPw());
		
		return resultMap;
	
	}

}
