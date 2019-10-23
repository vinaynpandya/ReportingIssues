package com.reporting.issues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ReportingIssues {
//Main class comment
	public static void main(String[] args) {
		SpringApplication.run(ReportingIssues.class, args);
	}
}
