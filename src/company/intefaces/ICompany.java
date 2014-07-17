package company.intefaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import company.entity.Employee;

public interface ICompany {
	
	void addEmployee(Employee employee);
	ArrayList<Employee> getEmployeeList();
	List<Employee> find(String value);
	ArrayList<Employee> sort(Comparator<Employee> comparator);
	
}