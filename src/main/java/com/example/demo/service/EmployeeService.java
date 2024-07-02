package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

	public Employee getEmpById(int id) throws EmployeeNotFoundException
	{
	
		Employee  user= empRepo.findByEmpId(id);
		if(user!=null)
		{
			return user;
		}
		else
		{
		throw new EmployeeNotFoundException("Employee not found with id: "+id);
		}
	}
}


//public Employee getEmp(String email)
//{
//	return empRepo.findbyName(email);
//}

