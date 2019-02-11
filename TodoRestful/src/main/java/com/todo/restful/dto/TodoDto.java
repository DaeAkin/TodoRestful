package com.todo.restful.dto;

public class TodoDto {

	int todo_no;
	int id_no;
	String todo;
	Boolean iscompleted;

	public TodoDto() {

	}

	public TodoDto(int todo_no, int id_no, String todo, Boolean iscompleted) {
		this.todo_no = todo_no;
		this.id_no = id_no;
		this.todo = todo;
		this.iscompleted = iscompleted;

	}

	public TodoDto(int id_no, String todo, Boolean iscompleted) {
		this.id_no = id_no;
		this.todo = todo;
		this.iscompleted = iscompleted;
	}

	public int getTodo_no() {
		return todo_no;
	}

	public void setTodo_no(int todo_no) {
		this.todo_no = todo_no;
	}

	public int getId_no() {
		return id_no;
	}

	public void setId_no(int id_no) {
		this.id_no = id_no;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Boolean getIscompleted() {
		return iscompleted;
	}

	public void setIscompleted(Boolean iscompleted) {
		this.iscompleted = iscompleted;
	}
	
	

}
