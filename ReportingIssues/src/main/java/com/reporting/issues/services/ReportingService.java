package com.reporting.issues.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.issues.jpa.model.ReportingEntity;
import com.reporting.issues.jpa.model.ResultReportingEntity;
import com.reporting.issues.jpa.repository.ReportingRepository;
import com.reporting.issues.jpa.repository.ResultReportingRepository;
import com.reporting.issues.model.Issues;
import com.reporting.issues.model.ResultReporting;


@Service
public class ReportingService {

	@Autowired
	ReportingRepository  reportingrepository;
	
	@Autowired
	ResultReportingRepository  resultreportingrepository;

		
	/**
	 * Create IssueReport 
	 * @return The IssuesInfo
	 */
	public Issues createReport(Issues issuesinfo) {
		
		ReportingEntity reportingentity = new ReportingEntity(issuesinfo.getId(),issuesinfo.getState(),issuesinfo.getTitle(),issuesinfo.getRepository(),issuesinfo.getCreated_at());
				
		reportingrepository.save(reportingentity);
		
		issuesinfo.setId(reportingentity.getId());
		
		return issuesinfo;
	}

	/**
	 * Update Report
	 * @return The IssuesInfo
	 */
	public Issues updateReport(int id,Issues issuesinfo) {
		
		ReportingEntity reportingentity = new ReportingEntity(issuesinfo.getId(),issuesinfo.getState(),issuesinfo.getTitle(),issuesinfo.getRepository(),issuesinfo.getCreated_at());
		
		reportingentity.setId(id);
		
		reportingrepository.save(reportingentity);
		
		return issuesinfo;
	}
	
	/**
	 * Retrieve Report 
	 * @return The IssuesInfo
	 */
	public Issues getReports(Issues issuesinfo) {

		List<ReportingEntity> lstReports = (List<ReportingEntity>) reportingrepository.findAll();
		
		for (ReportingEntity Report : lstReports)
		{
			issuesinfo.setId(Report.getId());
			issuesinfo.setState(Report.getState());
			issuesinfo.setTitle(Report.getTitle());
			issuesinfo.setRepository(Report.getRepository());
			issuesinfo.setCreated_at(Report.getCreated_at());
		}
				
		return issuesinfo;
	}

	
	public List<Issues> getAllReports() {
		// TODO Auto-generated method stub
		List<Issues> Reports = new ArrayList<>();
			
		for (ReportingEntity Report : reportingrepository.findAll())
		{
			Reports.add(new Issues(Report.getId(),Report.getState(),Report.getTitle(),Report.getRepository(),Report.getCreated_at()));
		}
		
		return Reports;
	}
	
	/**
	 * Get specific Report Details 
	 * @return Report
	 */
	public List<Issues> getReportById(int reportid) {
		// TODO Auto-generated method stub
		List<Issues> Reports = new ArrayList<>();
		
		ReportingEntity  reportentity = reportingrepository.getReportsById(reportid);
		
		Reports.add(new Issues(reportentity.getId(),reportentity.getState(),reportentity.getTitle(),reportentity.getRepository(),reportentity.getCreated_at()));
			
		return Reports;
	}
	
	/**
	 * Delete specific report by Id  
	 * @return true if deleted successfully
	 */
	public boolean deleteReport(int reportid) {
		ReportingEntity  reportentity = reportingrepository.getReportsById(reportid);
		
		if (reportentity == null ) {

			return false;
		}
		else {
			reportingrepository.delete(reportentity);
			return true;			
		}
	}
	
	/**
	 * Get open status Reports 
	 * @return open status Reports
	 */
	public List<Issues> getReportsByStatus() {
		// TODO Auto-generated method stub
		List<Issues> Reports = new ArrayList<>();
		
		for (ReportingEntity Report : reportingrepository.getReportsByStatus()) 
		{
		Reports.add(new Issues(Report.getId(),Report.getState(),Report.getTitle(),Report.getRepository(),Report.getCreated_at()));
		}
		return Reports;
		
	}
	
//	public List<ResultReporting> getReportsByTopDay() {
//		// TODO Auto-generated method stub
//		List<ResultReporting> ResultReport = new ArrayList<>();
//		
//		for (ResultReportingEntity Report : reportingrepository.getReportsByTopDay()) 
//		{
//			ResultReport.add(new ResultReporting(Report.getCreatedat(),Report.getRepository(),Report.getIssueoccurrences()));
//		}
//		
//		return ResultReport;
//		
//	}
	
	public ResultReporting getReportsByTopDay() {
		// TODO Auto-generated method stub
		ResultReporting ResultReport = new ResultReporting();
		//List<ResultReporting> ResultReport = new ArrayList<>();
		ResultReportingEntity Report =  resultreportingrepository.getReportsByTopDay();
		//for (ResultReportingEntity Report : reportingrepository.getReportsByTopDay()) 
		//{

			ResultReport.setCreatedat(Report.getCreatedat());
			ResultReport.setRepository(Report.getRepository());
			ResultReport.setIssueoccurrences(Report.getIssueoccurrences());
		//}
		
		return ResultReport;
		
	}
	
	

}
