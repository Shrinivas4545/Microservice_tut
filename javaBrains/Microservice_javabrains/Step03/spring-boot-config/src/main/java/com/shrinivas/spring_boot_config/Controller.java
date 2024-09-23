package com.shrinivas.spring_boot_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${my.fullGreetDesc}")
	private String greetMsg;
	
	@GetMapping("/greet")
	public String getGreeting() {
		return greetMsg;
	}
}
