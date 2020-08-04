package com.cg.validate;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.beans.Employee;
import com.cg.dao.Dao;
import com.cg.dao.DaoImpl;

public class ServiceValidateImp implements IServiceValidate {
	
	Dao dao;
	public ServiceValidateImp() {
		dao = new DaoImpl();
	
	}
	

	
@Override
public boolean employeeIdValidation(String employeeId) {
	return employeeId.matches("^[0-9]{5}_[a-zA-Z]{2}$");
}


@Override
public boolean employeeNameValidation(String employeeName) {
	return employeeName.matches("^[a-zA-Z]{2,}$");
	
}


@Override
public boolean employeeSalaryValidation(double salary) {
	return (salary>20000 && salary<500000);

	}

@Override
public boolean joinDateValidation(LocalDate date) {
	int k = date.compareTo(LocalDate.now());

	return (k>=0);
}


@Override
public void createEmployee(Employee e) {
	dao.createEmployee(e);
}

public List<Employee> getEmp(){
	return dao.getEmp();
	
}

}
