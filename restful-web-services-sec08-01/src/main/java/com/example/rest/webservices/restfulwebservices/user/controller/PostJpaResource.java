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
import com.example.rest.webservices.restfulwebservices.user.domain.Post;
import com.example.rest.webservices.restfulwebservices.user.domain.User;
import com.example.rest.webservices.restfulwebservices.user.jpa.PostJpaRepository;
import com.example.rest.webservices.restfulwebservices.user.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class PostJpaResource {

	@Autowired
	private PostJpaRepository postJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@GetMapping("jpa/posts")
	List<Post> retrieveAllPost() {
		return postJpaRepository.findAll();
	}
	
	@GetMapping("jpa/posts/{id}")
	public Post retrievePost(@PathVariable int id) {
		return new Post();
	}
	
	@GetMapping("jpa/users/{id}/posts")
	public List<Post> retrieveUserPost(@PathVariable int id) {
		Optional<User> user = userJpaRepository.findById(id);
		if (user.isEmpty()) 
			throw new UserNotFoundException("User Not Found");
		
		return user.get().getPosts(); 
	}

	@GetMapping("jpa/users/{user_id}/posts/{post_id}")
	public EntityModel<Post> retrieveUserPost(@PathVariable int user_id, @PathVariable int post_id) {
		Optional<Post> user = postJpaRepository.findById(user_id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		
		EntityModel<Post> userModel = EntityModel.of(user.get()); //wrapping user
		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(
						WebMvcLinkBuilder.methodOn(		// method mapping. cause if url changes it's hard to maintain
													getClass()  
												   )
													.retrieveAllPost() // the method, which are we want to map
						);  
		
		userModel.add(link.withRel("all-users")); // adding created link to wrapper with "all-users" key name;
		
		return userModel;
	}
	
	@DeleteMapping("jpa/posts/{id}")
	public void deletePost(@PathVariable int id) {
		postJpaRepository.deleteById(id);
		
	}
	
	@PostMapping("jpa/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userJpaRepository.findById(id);
		if (user.isEmpty()) 
			throw new UserNotFoundException("User Not Found");
		
		post.setUser(user.get());
		Post savedPost = postJpaRepository.save(post);  
		 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() //path of the current address (http://localhost:8080/users)
						.path("")	// appending variable
						.buildAndExpand() // replacing path variable
						.toUri();		// convert to uri
		
		return ResponseEntity.created(uri).build();
	}
}
