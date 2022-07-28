package com.todlist.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import task.Task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/")
	public List<Task> getTasks(){
		return List.of(
				new Task(1L,
						"Cleaning",
						"Household",
						LocalDate.of(2020, Month.APRIL,12),
						LocalDate.of(2021,Month.APRIL,12),
						"Mark",
						"Important")
		);
	}
}
