package com.example.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  Employee Directory CRUD APIs (implementation-oriented)
  Entity fields: id (auto), name, department, salary

  Task: Provide endpoints + annotations + code outline for:
  - add employee
  - get all employees
  - get by id
  - update
  - delete

  Key points: REST mapping design, validation, error handling, DTO vs entity, HTTP status codes
*/
@SpringBootApplication
public class EmployeeWebApplication {

	static void main(String[] args) {
		SpringApplication.run(EmployeeWebApplication.class, args);
	}
}
