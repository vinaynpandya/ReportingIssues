package com.reporting.issues.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resultreporting")
public class ResultReportingEntity {
	
	
	@Id
	@Column(name = "repository")
	private String repository;
	@Column(name = "issueoccurrences")
	private int issueoccurrences;
	@Column(name = "createdat")
	private Date createdat;
	
	public ResultReportingEntity() {
		
	}
	
	public ResultReportingEntity(Date createdat, String repository, int issueoccurrences) {
		super();
		this.createdat = createdat;
		this.repository = repository;
		this.issueoccurrences = issueoccurrences;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreated_at(Date createdat) {
		this.createdat = createdat;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public int getIssueoccurrences() {
		return issueoccurrences;
	}

	public void setIssueoccurrences(int issueoccurrences) {
		this.issueoccurrences = issueoccurrences;
	}
	
}
