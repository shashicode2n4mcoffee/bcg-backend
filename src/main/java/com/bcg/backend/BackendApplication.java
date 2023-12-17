package com.bcg.backend;

import com.bcg.backend.service.ConnectionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication  {

	@Autowired
	private ConnectionRequestService connectionRequestService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}
