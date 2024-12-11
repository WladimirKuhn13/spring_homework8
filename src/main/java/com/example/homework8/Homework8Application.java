package com.example.homework8;

import com.example.homework8.aspects.LoggingAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class Homework8Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework8Application.class, args);
	}

}
