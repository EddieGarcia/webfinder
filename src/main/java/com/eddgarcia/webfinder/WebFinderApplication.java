package com.eddgarcia.webfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eddgarcia.webfinder.repository.CustomerRepository;

@SpringBootApplication
public class WebFinderApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(WebFinderApplication.class, args);
	}
	
	// Executes just after applicationcontext is created and before springboot application starts up
	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data 
		//repository.deleteAll();
	}
}
