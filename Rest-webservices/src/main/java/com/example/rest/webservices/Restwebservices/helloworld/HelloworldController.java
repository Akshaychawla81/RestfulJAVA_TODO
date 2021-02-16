package com.example.rest.webservices.Restwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloworldController {
//method 
	@GetMapping( path="/Helloworld")
	public String Helloword() {
	return	"Hello World";
	}
	
	@GetMapping( path="/HelloworldBean/path-variable/{name}")
	public Helloworldbean HellowordBean(@PathVariable String name) {
	return new Helloworldbean(String.format("Hellow world %s", name));
	}
}
