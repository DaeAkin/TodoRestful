package com.todo.restful.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todo.restful.dto.MemberDto;
import com.todo.restful.service.LoginService;
import com.todo.restful.utils.DtoToMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class LoginServiceTest {
	
	@Autowired
	LoginService loginService;
	
	MemberDto member1;
	
	@Before
	public void setUp() {
		member1 = new MemberDto("test", "1234");
	}
	
	@Test
	public void andAndLogin() {
		
		loginService.deleteAllMember();
		
		loginService.
			memberAdd(DtoToMap.dtoToMemberDtoParam(member1));
		
		MemberDto loginedMember = 
				loginService.login(DtoToMap.dtoToMemberDtoParam(member1));
		
		assertThat(loginedMember, is(notNullValue()));
		
		assertThat(loginedMember.getId(), is(member1.getId()));
		
	}
	
	
	


}
