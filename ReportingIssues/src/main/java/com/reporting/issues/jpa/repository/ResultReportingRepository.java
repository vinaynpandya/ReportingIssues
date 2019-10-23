package com.reporting.issues.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.reporting.issues.jpa.model.ReportingEntity;
import com.reporting.issues.jpa.model.ResultReportingEntity;
import com.reporting.issues.model.ResultReporting;

public interface ResultReportingRepository extends CrudRepository<ResultReportingEntity, Integer> {
		
	@Query(value ="select CAST(created_at AS DATE) createdat,trim(repository) repository,count(repository) issueoccurrences\r\n" + 
			"from reporting where created_at in (SELECT TOP 1 CAST(created_at AS DATE) \r\n" + 
			"FROM reporting\r\n" + 
			"GROUP BY CAST(created_at AS DATE)\r\n" + 
			"ORDER By count(repository) desc)\r\n" + 
			"group by CAST(created_at AS DATE), trim(repository)", 
			  nativeQuery = true)
	public ResultReportingEntity getReportsByTopDay();
		
}
