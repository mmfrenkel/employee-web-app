package com.learning.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		// create employees, just in memory for now
		
		Employee employee1 = new Employee(1, "Leslie", "Andrews", "landrew@gmail.com");
		Employee employee2 = new Employee(2, "Harper", "Frenkel", "harper@dogs.com");
		Employee employee3 = new Employee(3, "Andy", "Grandy", "andy@grants.com");
		
		employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employees);
		return "list-employees";
	}

}
