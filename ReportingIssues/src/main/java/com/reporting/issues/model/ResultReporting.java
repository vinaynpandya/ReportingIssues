package com.reporting.issues.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ResultReporting {
	
	private Date createdat;
	private String repository;
	private int issueoccurrences;
	
	public ResultReporting() {
		
	}
	
	public ResultReporting(Date createdat, String repository, int issueoccurrences) {
		super();
		this.createdat = createdat;
		this.repository = repository;
		this.issueoccurrences = issueoccurrences;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
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
