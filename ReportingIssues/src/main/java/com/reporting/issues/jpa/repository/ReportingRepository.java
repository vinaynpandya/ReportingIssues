package com.reporting.issues.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.reporting.issues.jpa.model.ReportingEntity;
import com.reporting.issues.jpa.model.ResultReportingEntity;
import com.reporting.issues.model.ResultReporting;

public interface ReportingRepository extends CrudRepository<ReportingEntity, Integer> {
	
	@Query("select re from ReportingEntity re where re.id=:reportid")
	public ReportingEntity getReportsById(@Param("reportid") int id);
	
	@Query("select re from ReportingEntity re ")
	public List<ReportingEntity> getIssuesAll();
	
	@Query("select re from ReportingEntity re where re.state='open'")
	public List<ReportingEntity> getReportsByStatus();
		
}
