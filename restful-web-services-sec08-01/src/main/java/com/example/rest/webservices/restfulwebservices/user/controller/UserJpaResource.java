package com.example.rest.webservices.restfulwebservices.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restfulwebservices.user.UserNotFoundException;
import com.example.rest.webservices.restfulwebservices.user.domain.User;
import com.example.rest.webservices.restfulwebservices.user.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@GetMapping("jpa/users")
	List<User> retrieveAllUsers() {
		return userJpaRepository.findAll();
	}

	@GetMapping("jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userJpaRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		
		EntityModel<User> userModel = EntityModel.of(user.get()); //wrapping user
		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(
						WebMvcLinkBuilder.methodOn(		// method mapping. cause if url changes it's hard to maintain
													getClass()  
												   )
													.retrieveAllUsers() // the method, which are we want to map
						);  
		
		userModel.add(link.withRel("all-users")); // adding created link to wrapper with "all-users" key name;
		
		return userModel;
	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userJpaRepository.deleteById(id);
		
	}
	
	@PostMapping("jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userJpaRepository.save(user);  
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() //path of the current address (http://localhost:8080/users)
						.path("/{id}")	// appending variable
						.buildAndExpand(savedUser.getId()) // replacing path variable
						.toUri();		// convert to uri
		
		return ResponseEntity.created(uri).build();
	}
}
