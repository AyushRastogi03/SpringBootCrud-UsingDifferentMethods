package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.cruddemo.entity.Employee ;
import com.springboot.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	// quick and dirty : inject employee dao 
	@Autowired
	 private EmployeeService empService ;
	 
	
	
	// expose /employees and return list of employees
	 
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return empService.findAll();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee findById(@PathVariable int employeeID) {
		Employee theemp = empService.findById(employeeID);
		
		if(theemp == null) {
			throw new RuntimeException("Employee id not found");
		}
		return theemp ;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theemp) {
		
		theemp.setId(0);
		empService.save(theemp);
		
		return theemp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		empService.save(emp);
		
		return emp;
		
	}
	
	@DeleteMapping("/employees/{employeeId}")
   public String deleteEmployee(@PathVariable int employeeId) {
		Employee temp = empService.findById(employeeId);
		
		if(temp==null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		empService.deleteById(employeeId);
		
		return "delete Employee having id :" + employeeId ;
		
	}
	
	
}
