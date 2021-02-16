package com.example.rest.webservices.Restwebservices;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.Restwebservices.todo.Todo;
import com.example.rest.webservices.Restwebservices.todo.TodoHardcordedService;
import com.example.rest.webservices.Restwebservices.todo.TodojpaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoJPAResource2 {
	
	@Autowired
	private TodojpaRepository TodojpaRepo;
	
	@GetMapping(path="/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(String username){
		System.out.println(TodojpaRepo.findByUsername(username));
		return TodojpaRepo.findAll(); 
	}
		
	@DeleteMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username , @PathVariable long id) {
	TodojpaRepo.deleteById(id);

			return ResponseEntity.noContent().build();
		
		
	}
	
	@GetMapping(path="/jpa/users/{username}/todos/{id}")
	public Todo gettodo(@PathVariable String username , @PathVariable long id) {
		return TodojpaRepo.findById(id).get();
		
		
	}
	
	@PutMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Todo todo){
	todo.setUsername(username);
		Todo todoUpdated = TodojpaRepo.saveAndFlush(todo);
		
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
		}

	@PutMapping(path="/jpa/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username ,@RequestBody Todo todo) {
		todo.setUsername(username);
		Todo todosave = TodojpaRepo.save(todo);
		System.out.println("*******************************************88");
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(todosave.getID()).toUri();
		return ResponseEntity.created(uri).build();	}	
	
}
