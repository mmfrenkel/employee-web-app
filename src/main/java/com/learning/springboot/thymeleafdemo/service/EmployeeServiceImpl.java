package com.learning.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.learning.springboot.thymeleafdemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired                // qualify which bean to use via bean id
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override 
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override 
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find Employee with id: " + id);
		}
		
		return employee;
	}

	@Override 
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override 
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
