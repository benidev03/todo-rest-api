package com.example.todo.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	
	@Autowired
	private TodoRepository todoRepository;
	
	
	public List<Todo> getAllTodos(){
		
		return todoRepository.findAll();
	}
	
	
	public Optional<Todo> getById(int todoId) {
		
		return todoRepository.findById(todoId);
	}
	
	
	public Todo create(String textInput) {
		
		Todo todo = new Todo();
		
		todo.setTextInput(textInput);
		
		todo.setStateCompleted(true);
	
		return todoRepository.save(todo);
	}
	

	public void deleteTodo(int todoId) {
		
		todoRepository.deleteById(todoId);
		
	}
		
	public ResponseEntity<Todo> updateTodo(int todoId, String newTextInput) {
		
		Optional<Todo> update = todoRepository.findById(todoId);
		
		if(update.isEmpty())
			
			return new ResponseEntity<Todo>((Todo) null, HttpStatus.NOT_FOUND);
		else
			
			update.get().setTextInput(newTextInput);
		
		return new ResponseEntity<Todo> (todoRepository.save(update.get()), HttpStatus.OK);
	}
	
		
		


}
