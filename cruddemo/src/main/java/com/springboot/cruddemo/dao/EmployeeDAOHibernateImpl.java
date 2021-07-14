package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;



import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
     
	 //define field for entityManager
	// setup injection 
	 @Autowired
	 private EntityManager entityManager ;
	
	  
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		  // get the current hiberante session 
		  Session currentSession = entityManager.unwrap(Session.class);
		  
		  
		  
		// create a query 
		Query<Employee> thequery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query 
		List<Employee> emp = thequery.getResultList();
		// return result 
		return emp;
	}



	@Override
	public Employee findById(int theid) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmp = 
				currentSession.get(Employee.class,theid);
		
		
		
		return theEmp;
	}



	@Override
	public void save(Employee theEmp) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save emp 
		
		currentSession.saveOrUpdate(theEmp);
		
	}



	@Override
	public void deleteById(int theid) {
		// TODO Auto-generated method stub
		//get session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete 
		
		Query theQue = 
				currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQue.setParameter("employeeId",theid);
		
		theQue.executeUpdate();
		
		
	}
	
	

}
