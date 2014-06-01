package company.intefaces;

import java.util.ArrayList;

import company.datamodels.Employee;

public interface ISource {
	
	void save(String path, ArrayList<Employee> empl);
	ArrayList<Employee> load(String path);
}
