package com.reporting.issues.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reporting.issues.model.Issues;
import com.reporting.issues.model.ResultReporting;
import com.reporting.issues.services.ReportingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/services")
@Api("Reporting Issues application which allow creating new issues and update existing issues and dose basic crud operations")
public class  ReportController {

	@Autowired
	ReportingService  reportService;

	@PostMapping(value = "/report")
	@ApiOperation(value = "Creates new IssueReport with information provided.")
	public Issues createReport(@RequestBody Issues issuesInfo) {
		return reportService.createReport(issuesInfo);
	}

	@PutMapping("/report/{id}")
	@ApiOperation(value = "Update existing ReporingIssues with information provided.")
	public Issues updateReport(@PathVariable int id, @RequestBody Issues issuesInfo) {
		return reportService.updateReport(id,issuesInfo);
	}

	@GetMapping("/reports")
	@ApiOperation(value = "Get all existing Reports with information provided.")
	public List<Issues> getAllReports() {
		return reportService.getAllReports();
	}

	@GetMapping("/reports/{id}")
	@ApiOperation(value = "Get Reports by ID provided.")
	public List<Issues> getReportById1(@PathVariable int id) {
		return reportService.getReportById(id);
	}

	@DeleteMapping(value = "/reports/{id}")
	@ApiOperation(value = "Delete IssueReport By Id")
	public boolean deleteReport(@PathVariable(value="id") int id) {
		return reportService.deleteReport(id);
	}
	
	@GetMapping("/reports/status")
	@ApiOperation(value = "Get  open status reports.")
	public List<Issues> getReportsByStatus() {
		return reportService.getReportsByStatus();
	}
	
	@GetMapping("/reports/output")
	@ApiOperation(value = "Get top day of issuses logged report.")
	public ResultReporting getReportsByTopDay() {
		return reportService.getReportsByTopDay();
//	public List<ResultReporting> getReportsByTopDay() {
//		return reportService.getReportsByTopDay();
	}


}