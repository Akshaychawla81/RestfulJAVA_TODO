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
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoResource {
	@Autowired
	private TodoHardcordedService TodoService;
	
	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(String username){
		return TodoService.findAll(); 
	}
	
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username , @PathVariable long id) {
		Todo todo = TodoService.DeletetodobyId(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping(path="/users/{username}/todos/{id}")
	public Todo gettodo(@PathVariable String username , @PathVariable long id) {
		return TodoService.FindbyID(id);
		
		
	}
	
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Todo todo){
	
		Todo todoUpdated = TodoService.save(todo);
		
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
		}

	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username ,@RequestBody Todo todo) {
		Todo todosave = TodoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(todosave.getID()).toUri();
		return ResponseEntity.created(uri).build();	}	
	
}
