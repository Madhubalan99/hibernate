	package com.jsp.employeedao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.employeedto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory	=Persistence.createEntityManagerFactory("madhu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void testsave(List<Employee> employees) {
		entityTransaction.begin();
		entityManager.persist(employees.get(0));
		entityManager.persist(employees.get(1));
		entityManager.persist(employees.get(2));
		entityTransaction.commit();
	}
	public void deleteById(Employee employee) {
		Employee e1 = entityManager.find(Employee.class, employee.getId());
		if(e1 !=null) {
			entityTransaction.begin();
			entityManager.remove(e1);
			entityTransaction.commit();
		}
		else {
			System.out.println("entity not found");
		}
		
	}
	
	public Employee updateById(Employee employee) {
		Employee e2= entityManager.find(Employee.class, employee.getId());
		if (e2!=null) {
			e2.setName("prateeksha");
			e2.setEmail("prateeksha@gmail.com");
			entityTransaction.begin();
			entityManager.merge(e2);
			entityTransaction.commit();
		}
		return e2;
		
	}
	public void getById(Employee employee) {
		Employee e3 = entityManager.find(Employee.class, employee.getId());
		if(e3 !=null) {
			System.out.println(e3.getEmail());
			System.err.println(e3.getId());
			System.out.println(e3.getName());	
		}
	}
	public void getAll(Employee employee) {
		String sql ="SELECT * FROM EMPLOYEE E";
		Query  q = entityManager.createQuery(sql);
		
		List<Employee> employees = q.getResultList();
		for(Employee employee2: employees) {
			System.out.println("=======================");
			System.out.println(employee2.getId() );
			System.out.println(employee2.getName());
			System.out.println(employee2.getEmail());
		}
	}
}
