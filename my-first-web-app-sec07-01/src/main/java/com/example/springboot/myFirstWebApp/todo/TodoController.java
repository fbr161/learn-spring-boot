package com.example.springboot.myFirstWebApp.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		model.put("todos", todoService.findByUsernameH2(getLoggedInUsername()));
		
		return "todo/listTodos";
	}

	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(0, "dauf", "desc", LocalDate.now(), false);
		model.put("todo", todo);
		
		return "todo/addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Validated Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo/addTodo";
		
		todoService.addNewTodo(getLoggedInUsername(), todo.getDescription(), LocalDate.now().plusWeeks(3), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo/addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(@Validated Todo todo, BindingResult result) {
		
		if (result.hasErrors())
			return "todo/addTodo";
		
		todoService.updateTodo(todo);
		
		return "redirect:list-todos";
	}
	

}
 