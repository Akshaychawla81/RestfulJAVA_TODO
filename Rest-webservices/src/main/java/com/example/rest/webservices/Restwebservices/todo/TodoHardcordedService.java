package com.example.rest.webservices.Restwebservices.todo;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

import org.springframework.stereotype.Service;


@Service
public class TodoHardcordedService {
private static List<Todo> todos= new ArrayList();
private static List<Todo> LL= new LinkedList();


private static long counter = 0 ; 
static{
	
	todos.add(new Todo(++counter,"Admin","Learn to Dance",new Date(),false));
	todos.add(new Todo(++counter,"Admin","Learn to Play",new Date(),false));
	todos.add(new Todo(++counter,"Admin","Learn to Eat", new Date(),false));
}

public List<Todo> findAll(){
	return todos;
}
public Todo DeletetodobyId(Long id){
	for(Todo todo:todos)
	{if(todo.getID()==id) {
		LL.remove(todo);
		return todo;
	}
		
		
	}
	return null;
	
 }

public Todo save(Todo todo) {
	if(todo.getID()==-1||todo.getID()==0) {
		todo.setID(++counter);
	
		todos.add(todo);
		
	}else 
	{ DeletetodobyId(todo.getID());
	todos.add(todo);		
	}
	return todo;
}
public Todo FindbyID(long id){
	for(Todo todo:todos)
	{if(todo.getID()==id) {
		return todo;

} }

		return null;
}
//public Todo UpdateTodobyId(long id) {
//	for(Todo todo:todos)
//	{if(todo.getID()==id) {
//		todos.
//		return todo;
//	}
//		
//		
//	}
//	return null;
	
// }
}
