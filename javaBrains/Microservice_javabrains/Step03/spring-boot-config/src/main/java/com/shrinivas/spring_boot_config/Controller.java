package com.shrinivas.spring_boot_config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

//	@Value("${my.fullGreetDesc:default}")
	@Value("${my.fullGreetDesc:default value}")  // takes default value when my.fullGreetDesc is not there in application.properties
	private String greetMsg;
	
	@Value("${my.list}")
	private List<String> list;
	
	@Value("#{${dbValues}}")
	private Map<String, String> map;
	
	@Autowired
	private DbConnection dbConnection;
	
	
	@GetMapping("/greet")
	public String getGreeting() {
		return greetMsg+map;
	}
	
	@GetMapping("/db")
	public String getDbDetails() {
		return dbConnection.getConnection()+dbConnection.getHost()+dbConnection.getPort();
	}
}
