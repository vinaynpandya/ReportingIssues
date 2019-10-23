package com.reporting.issues.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reporting")
public class ReportingEntity {
	
	
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "state")
	private String state;
	@Column(name = "title")
	private String title;
	@Column(name = "repository")
	private String repository;
	@Column(name = "created_at")
	private Date created_at;
	
	public ReportingEntity() {
		
	}
	
	public ReportingEntity(int id, String state, String title, String repository, Date created_at) {
		super();
		this.id = id;
		this.state = state;
		this.title = title;
		this.repository = repository;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	

}
