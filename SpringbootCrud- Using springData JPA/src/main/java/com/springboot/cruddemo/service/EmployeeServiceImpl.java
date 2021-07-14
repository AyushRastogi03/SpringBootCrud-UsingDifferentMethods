package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeRepository;
//
//import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	
	@Autowired
//	@Qualifier("employeeDAOJpaImpl")      // field injection 
	private EmployeeRepository empRepo ;      
	
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employee) { // constructor injection 
//		employeeDAO = employee;
//	}
//	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub 
		
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = empRepo.findById(theId);
		Employee theemp = null ;
		if(result.isPresent()) {
			theemp = result.get();
		}
		else {
			// we didnt find employee 
			
			throw new RuntimeException("Did not find emp Id -"+ theId);
			
		}
		return theemp;
	}

	@Override
	public void save(Employee theEmp) {
		// TODO Auto-generated method stub
        empRepo.save(theEmp);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
       empRepo.deleteById(theId);
	}

}
