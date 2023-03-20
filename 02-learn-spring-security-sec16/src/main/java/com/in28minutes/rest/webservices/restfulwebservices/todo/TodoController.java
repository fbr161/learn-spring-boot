package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;
	
	
	@GetMapping("/todos")
	List<Todo> retrieveAllTodos() {
		return todoService.retrieveAll();
	}
	
	@GetMapping("users/{username}/todos")
	List<Todo> specificUsersTodo(@PathVariable String username) {
		
		return todoService.findByUsername(username);
	}
	
	@PostMapping("users/{username}/todos")
	void addTodo(@PathVariable String username, @RequestBody Todo todo) {
		String description = "Learn java";
		LocalDate targetDate = LocalDate.now().plusDays(5); 
		boolean done = false;
		
//		return todoService.addTodo(todo);
	}
}
