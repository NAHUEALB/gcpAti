package com.example.googleAtiProyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GoogleAtiProyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleAtiProyectApplication.class, args);
	}

	@RestController
	class HelloController{
		@GetMapping("/")
		String hello(){
			return "Spring en Gcp PADDDDRE";
		}
	}

}
