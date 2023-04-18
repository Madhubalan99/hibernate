package com.jsp.service;

import java.util.List;

import com.jsp.employeedao.EmployeeDao;
import com.jsp.employeedto.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public void testSave(List<Employee> employees) {
		employeeDao.testsave(employees);
	}
	
	public void deleteById(Employee employee) {
		employeeDao.deleteById(employee);
	}
	
	public void updateById(Employee employee) {
		employeeDao.updateById(employee);
	}
	
	public void  getById(Employee employee) {
		employeeDao. getById(employee);
	}
	
	public void getAll(Employee employee) {
		employeeDao.getAll(employee);
	}
}
