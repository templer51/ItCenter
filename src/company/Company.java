package company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import company.entity.Employee;
import company.helpers.Constants;
import company.helpers.Finder;
import company.intefaces.ICompany;
import company.intefaces.IFinder;
import company.intefaces.ISource;
import company.sources.CompanyFile;

public class Company implements ICompany{
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ISource saver;
	private IFinder<List<Employee>> finder;
	
	public Company(){
		// создание ресурса для хранения данных
		saver = new CompanyFile(Constants.FILE_PATH);
		finder = new Finder<List<Employee>, Employee>();
		
		employees = saver.load();
		if (employees == null){
			employees = new ArrayList<Employee>();
		}
	}
	
	public void addEmployee(Employee employee){
		employees.add(employee);
		saver.save(employees);
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> find(String value) {
		return finder.find(employees, value);
	}

	public ArrayList<Employee> sort(Comparator<Employee> comparator) {
		for(int i = 0; i < employees.size(); i++){
			for(int j = i; j > 0 && comparator.compare(employees.get(j), employees.get(j - 1)) < 0; j--){
				Employee t = employees.get(j);
				employees.set(j, employees.get(j - 1));
				employees.set(j - 1, t);
			}
		}
		return employees;
	}
	
}
