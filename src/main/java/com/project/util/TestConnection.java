package com.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestConnection {
	
	@Autowired
	private DatabaseConnectionTest dbTest;
	
	@GetMapping("/testConnection")
	@ResponseBody
	public String testConnection() {
		try {
			dbTest.testConnection();
			return "Database connection test successful!";
		} catch(Exception e) {
			return "Error testing database connection: " + e.getMessage();
		}
	}
}
