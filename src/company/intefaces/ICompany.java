package company.intefaces;

import java.util.ArrayList;
import java.util.Comparator;

import company.datamodels.Employee;

public interface ICompany {
	
	void addEmployee(Employee employee);
	ArrayList<Employee> getEmployeeList();
	Employee find(Comparator<Employee> comparator);
	ArrayList<Employee> sort(Comparator<Employee> comparator);
	
}