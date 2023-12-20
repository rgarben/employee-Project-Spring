package com.jacaranda.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository mployeeRepository;
	
	public List<Employee> getEmployee(){
		return mployeeRepository.findAll();
	}
	
}
