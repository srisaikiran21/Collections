package com.cg.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cg.beans.Address;
import com.cg.beans.Department;
import com.cg.beans.Employee;
import com.cg.validate.IServiceValidate;
import com.cg.validate.ServiceValidateImp;

public class Main {
public static void main(String[] args) {
	IServiceValidate service = new ServiceValidateImp();
	
	Employee employee =null;
	
	List<Address> address =null;
	Scanner scanner =new Scanner(System.in);
	
	
	while(true) {
		System.out.println("Enter 1 to create an employee");

	System.out.println("Enter 2 to sort employee by Id");
	System.out.println("Enter 3 to sort employee by firstname");
	System.out.println("Enter 4 to sort employee by lastname");

	System.out.println("Enter 5 to sort employee by salary");
	
	System.out.println("Enter 6 to sort employee by department");
	System.out.println("Enter 7 to exit");
	
	switch(scanner.nextInt()) {
	
	case 1:
		System.out.println("Enter employee id");
		String employeeId = scanner.next();
		if(service.employeeIdValidation(employeeId)) 
		{
			employee = new Employee();
			employee.setEmployeeId(employeeId);	
	}
		else
		{
			System.out.println("Invalid employee Id,it should contain 5 numbers and 2 characters ");
		break;
		}
	
		System.out.println("Enter first name");
		String firstName = scanner.next();
		if(service.employeeNameValidation(firstName)) {
			employee.setFirstName(firstName);	
	}
		else
		{
			System.out.println("Invalid first name ");
			break;
		}
		
		System.out.println("Enter last name");
		String lastName = scanner.next();
		if(service.employeeNameValidation(lastName)) {
			employee.setLastName(lastName);	
	}
		else
		{
			System.out.println("Invalid last name ");
			break;
		}		
		
		System.out.println("Enter salary ");
		double salary = scanner.nextDouble();
		if(service.employeeSalaryValidation(salary)) {
			employee.setSalary(salary);	
	}
		
		else
		
		{
			System.out.println("Invalid Salary range, Salary should be in between 20000 and 500000");
			break;
		}	
		
		
		System.out.println("Enter joining date (yyyy-mm-dd) : ");
		String  joiningDate= scanner.next();
		LocalDate date = LocalDate.parse(joiningDate);
		if(service.joinDateValidation(date)) 
		{
			employee.setDateOfJoining(date);	
	}
		else
		{
			System.out.println("Invalid date, date should be today or future date");
			break;
		}	
		
		Department department = new Department();
		
		System.out.println("Enter Department Id");
		String departmentId = scanner.next();
		department.setDepartmentId(departmentId);
		
		System.out.println("Enter Department name");
		String departmentName = scanner.next();
		department.setDepartmentName(departmentName);
		
		System.out.println("Enter Department location");
		String location = scanner.next();
		department.setLocation(location);
		
		employee.setDepartment(department);
		
		
		System.out.println("Enter the number of address");
		int num = scanner.nextInt();
		
	
		address = new ArrayList<Address>(num);
		
		for(int i=0;i<num;i++) {
			Address addres = new Address();
			
			System.out.println("Enter address id");
			int addressId = scanner.nextInt();
			addres.setAddressId(addressId);
			
			System.out.println("Enter address line ");
		   String addressline = scanner.next();
			addres.setAddressline1(addressline);
			
			System.out.println("Enter City ");
			 String city = scanner.next();
				addres.setCity(city);
				
			System.out.println("Enter State");
			String state = scanner.next();
			addres.setState(state);
			
			address.add(addres);
			
		}
		
		employee.setAddress(address);
		service.createEmployee(employee);
		break;
		
		
	case 2:
		
		System.out.println("Sort by EmployeeId ");
		Comparator<Employee> sortById = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getEmployeeId().compareTo(e2.getEmployeeId());
			}
		};
		
		Collections.sort(service.getEmp(),sortById);
		for(Employee e : service.getEmp())
			System.out.println(e);
		break;
		
		
		
	case 3:	
		
		System.out.println("Sort by first name ");
		Comparator<Employee> sortByFirstName = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getFirstName().compareTo(e2.getFirstName());
			}
		};
		
		Collections.sort(service.getEmp(),sortByFirstName);
		for(Employee e : service.getEmp())
			System.out.println(e);
		break;
		
		
	case 4:
		
		System.out.println("Sort by last name ");
		Comparator<Employee> sortByLastName = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getLastName().compareTo(e2.getLastName());
			}
		};
		
		Collections.sort(service.getEmp(),sortByLastName);
		for(Employee e : service.getEmp())
			System.out.println(e);
		break;
		
	case 5:
		
		System.out.println("Sort by Salary ");
		Comparator<Employee> sortBySalary = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				if(e1.getSalary()<e2.getSalary())
					return 1;
				else if(e1.getSalary()>e2.getSalary())
					return -1;
				else
					return 0;
			}
		};
		
		Collections.sort(service.getEmp(), sortBySalary);
		for(Employee e : service.getEmp())
			System.out.println(e);
		break;
	
	
	case 6:
		
	System.out.println("Sort By Department Id ");
	Comparator<Employee> sortByDeptId = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getDepartment().getDepartmentId().compareTo(e2.getDepartment().getDepartmentId());
		}
	};
	
	
	Collections.sort(service.getEmp(), sortByDeptId);
	for(Employee e : service.getEmp())
		System.out.println(e);
	
	System.out.println("Sort By Department Name in ascnding order :");
	Comparator<Employee> sortByDeptName = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getDepartment().getDepartmentName().compareToIgnoreCase(o2.getDepartment().getDepartmentName());
		}
	};
	
	
	Collections.sort(service.getEmp(), sortByDeptName);
	for(Employee e : service.getEmp())
		System.out.println(e);
	break;	
	
	
	
	case 7:
		
		System.out.println("Thank you");
         break;
	}
	
	}
}
}
