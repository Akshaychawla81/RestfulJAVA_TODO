package com.example.rest.webservices.Restwebservices.helloworld;

public class Helloworldbean {

	private String Hello;

	public Helloworldbean(String Hello) {
		
		this.Hello = Hello; 
	}

	@Override
	public String toString() {
		return "Helloworldbean [Hello=" + Hello + "]";
	}

	public String getHello() {
		return Hello;
	}

	public void setHello(String hello) {
		Hello = hello;
	}
}
