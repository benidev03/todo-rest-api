package com.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String textInput;
	
	private boolean stateCompleted = false;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTextInput() {
		return textInput;
	}


	public void setTextInput(String testInput) {
		this.textInput = testInput;
	}


	public boolean isStateCompleted() {
		return stateCompleted;
	}


	public void setStateCompleted(boolean state) {
		this.stateCompleted = state;
	}

}
