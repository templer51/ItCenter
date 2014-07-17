package company.entity;

import java.util.ArrayList;
import java.util.List;

import company.helpers.Constants;
import company.helpers.Finder;
import company.intefaces.ICompany;
import company.intefaces.IFinder;
import company.intefaces.ISource;
import company.sources.CompanyFileSource;

public class Company implements ICompany{
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ISource loader;
	private IFinder<List<Employee>> finder;
	
	public Company(){
		// создание ресурса для хранения данных
		loader = new CompanyFileSource(Constants.FILE_PATH);
		finder = new Finder<List<Employee>, Employee>();
		
		employees = loader.load();
		if (employees == null){
			employees = new ArrayList<Employee>();
		}
	}
	
	public void addEmployee(Employee employee){
		employees.add(employee);
		loader.save(employees);
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return employees;
	}

	public List<Employee> find(String value) {
		return finder.find(employees, value);
	}

}
