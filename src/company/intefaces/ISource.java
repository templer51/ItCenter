package company.intefaces;

import java.util.ArrayList;

import company.entity.Employee;

public interface ISource {
	
	void save(ArrayList<Employee> empl);
	ArrayList<Employee> load();
}
