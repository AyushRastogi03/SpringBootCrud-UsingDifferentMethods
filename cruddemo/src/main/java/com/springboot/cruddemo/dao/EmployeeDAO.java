package com.springboot.cruddemo.dao;
 
import java.util.List;

import com.springboot.cruddemo.entity.Employee ;

public interface EmployeeDAO {
    
	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theEmp);
	
	public void deleteById(int theid);
	
}
