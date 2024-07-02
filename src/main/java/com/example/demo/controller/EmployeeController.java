package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String getData() {
		System.out.println("Hello Bro");
		return "Hello java";
	}

//	@PostMapping(path="/addEmp")
//	public Employee addEmployee(@RequestBody Employee emp)
//	{
//
//		return empService.addEmployee(emp);
//	}
	@PostMapping(path = "/addEmp") //signup
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee emp) {

//		return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
		return new ResponseEntity<>(empService.addEmployee(emp), HttpStatus.CREATED);
	

	}

//	@GetMapping("/getAllEmp")
//	public List<Employee> getAllEmployees() {
//		return empService.getEmployees();
//	}
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> empList = empService.getEmployees();
		if (empList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		return ResponseEntity.of(Optional.of(empList));
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmp(@PathVariable int id) throws EmployeeNotFoundException
	{
		return ResponseEntity.ok(empService.getEmpById(id));
	}

}
