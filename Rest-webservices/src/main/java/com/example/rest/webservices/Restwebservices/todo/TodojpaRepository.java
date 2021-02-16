package com.example.rest.webservices.Restwebservices.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TodojpaRepository extends JpaRepository<Todo, Long> {

	 List<Todo> findByUsername(String username);
}
 