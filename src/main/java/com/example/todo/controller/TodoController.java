package com.example.todo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/list")
	public List<Todo> getAllTodo(){
		
		return todoService.getAllTodos();
	}
	

	@PostMapping("/create/{textInput}") 
	public List<Todo> insertToDo(@PathVariable(value = "textInput") String textInput) {	
		
		todoService.create(textInput);
		return todoService.getAllTodos();
	}
	
	@GetMapping("/{todoId}")
	public Optional<Todo> getTodoById(@PathVariable(value = "todoId") int todoId) {
		
		return todoService.getById(todoId);
	}
	
	@DeleteMapping("/delete/{todoId}")
	public List<Todo> rdeleteToDo(@PathVariable(value = "todoId") int todoId){
		
		todoService.deleteTodo(todoId);
		
		return todoService.getAllTodos();
	}
	
	@PutMapping("/update/{todoId}/{newTextInput}") 
	public List<Todo> updateToDo(@PathVariable(value = "todoId") int todoId, @PathVariable(value = "newTextInput") String newTextInput){
		
		todoService.updateTodo(todoId, newTextInput);
		
		return todoService.getAllTodos();
	}
	
	
	
	
}
