package com.todo.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restful.service.TodoService;

@CrossOrigin
@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	

	

}
