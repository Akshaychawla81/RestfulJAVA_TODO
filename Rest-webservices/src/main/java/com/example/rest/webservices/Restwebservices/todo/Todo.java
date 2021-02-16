package com.example.rest.webservices.Restwebservices.todo;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long ID;
	
	
	private String username;
	private String description;
	private Date tagetdate;
	private boolean isDone;
	
	public Long getID() {
		return ID;
	}
	
	protected Todo()
	{}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	public void setID(Long counter) {
		ID = counter;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date  getTagetdate() {
		return tagetdate;
	}

	public void setTagetdate(Date tagetdate) {
		this.tagetdate = tagetdate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Todo(long iD, String username, String description, Date simpleDateFormat, boolean isDone) {
		super();
		ID = iD;
		this.username = username;
		this.description = description;
		this.tagetdate = simpleDateFormat;
		this.isDone = isDone;
	}
}
