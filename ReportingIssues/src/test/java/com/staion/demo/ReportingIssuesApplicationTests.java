

package com.staion.demo;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.reporting.issues.ReportingIssues;


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes =ReportingIssues.class
		)
@AutoConfigureMockMvc
public class ReportingIssuesApplicationTests {

	@Autowired
	MockMvc  mockMvc;

	@Test
	public void  getAllReportsTest() throws Exception {

		mockMvc.perform(get("/services/reports").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)));

	}

	@Test
	public void getReportTest() throws Exception {


		mockMvc.perform(get("/services/reports/23")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());

		//mockMvc.perform(get("/services/reports/24")
				//.contentType(MediaType.APPLICATION_JSON))

		//.andExpect(status().isOk())
		//.andExpect(jsonPath("$.reportid", is(23)));

	}

	
}


