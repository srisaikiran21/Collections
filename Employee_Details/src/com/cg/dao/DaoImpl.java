package com.cg.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cg.beans.Employee;

public class DaoImpl implements Dao {
List<Employee> emp = new ArrayList<Employee>();


@Override
public void createEmployee(Employee e) {
	emp.add(e);
	System.out.println("Employee creation is done");
}


public List<Employee> getEmp() {
	
	return emp;
}

}
