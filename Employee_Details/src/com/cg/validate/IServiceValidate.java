package com.cg.validate;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.beans.Employee;

public interface IServiceValidate {
	
	public boolean employeeIdValidation(String employeeId);
	public boolean employeeSalaryValidation(double salary);
	public boolean employeeNameValidation(String employeeName);
	public boolean joinDateValidation(LocalDate date);
	
	
	public void createEmployee(Employee e);
	
	public List<Employee> getEmp();
}
