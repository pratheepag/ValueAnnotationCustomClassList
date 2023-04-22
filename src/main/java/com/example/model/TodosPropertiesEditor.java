package com.example.model;

import java.beans.PropertyEditorSupport;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodosPropertiesEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ObjectMapper mapper = new ObjectMapper();
		List<Todo> todoList = null;
		try {
			todoList = mapper.readValue(text, new TypeReference<List<Todo>>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Todos todos = new Todos();
		todos.setTodos(todoList);
		setValue(todos);
	}
}
