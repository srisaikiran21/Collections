package com.cg.dao;

import java.util.List;
import java.util.Set;

import com.cg.beans.Employee;

public interface Dao {
	
	public void createEmployee(Employee e);
	
	public List<Employee> getEmp();
}

