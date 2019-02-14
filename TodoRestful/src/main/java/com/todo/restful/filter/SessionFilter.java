package com.todo.restful.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.todo.restful.exception.SessionInvalidException;

public class SessionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("---- doFilter ----");
		
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println(request.getRequestURL());
		
		HttpSession session = request.getSession();
		System.out.println(" 세션 확인 : " + session.getAttribute("loginSession"));
		
		String path = ((HttpServletRequest) req).getRequestURI();
		if (path.contains("/login")) { // 추후 수정
		    chain.doFilter(request, res); 
		} else {
		   if(session.getAttribute("loginSession") == null) {
			   throw new SessionInvalidException("세선이 만료되었습니다.");
		   }
		}
		
	
		chain.doFilter(request, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
