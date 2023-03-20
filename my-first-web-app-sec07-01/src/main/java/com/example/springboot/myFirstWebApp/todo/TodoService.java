package com.example.springboot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int coutTodos = 0;
	@Autowired
	private TodoRepository todoRepository;
	
	static {
		todos.add(new Todo(++coutTodos, "fuad", "Learn Java", LocalDate.now().plusWeeks(1), false));
		todos.add(new Todo(++coutTodos, "fuad", "Learn Spring Core", LocalDate.now().plusWeeks(2), false));
		todos.add(new Todo(++coutTodos, "fuad", "Learn Spring Boot", LocalDate.now().plusWeeks(3), false));
	}
	
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public List<Todo> findByUsernameH2(String username) {
		return todoRepository.findByUsername(username);
	}

	public void addNewTodo(String username, String description, LocalDate target, Boolean isDone) {
		Todo todo = new Todo(++coutTodos, username, description, target, isDone);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
