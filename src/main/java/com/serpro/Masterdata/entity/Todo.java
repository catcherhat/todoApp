package com.serpro.Masterdata.entity;

import java.time.LocalDate;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.serpro.Masterdata.repository.TodoRepository;
//import com.serpro.Masterdata.service.TodoService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="cw_todo")
public class Todo {
//	
//	@Autowired
//	private TodoRepository todorepo;
//	
//	@Autowired
//	private TodoService todoserv;
	
public Todo() {
	
}
	
	public Todo(int id, String username, String description, LocalDate targetdate, String status, String done) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.status = status;
		this.done = done;
		
	}

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	//	@Size(min=10, message="Enter atleast 10 characters!")
	private String description;
	
	private LocalDate targetdate;
	
	private String status;
	
	private String done;
}
