package company;
import java.util.ArrayList;

public class Company{
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee){
		employees.add(employee);
		MySaver.save(employees);
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return MySaver.load();
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
}