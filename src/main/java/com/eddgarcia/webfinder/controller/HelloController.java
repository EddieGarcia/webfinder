package com.eddgarcia.webfinder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi Mate!";
	}
}
