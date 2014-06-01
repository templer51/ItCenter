package company;
import java.util.ArrayList;
import java.util.Comparator;

public class Company implements ICompany{
	
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

	@Override
	public Employee find(Comparator<Employee> comparator) {
		
		return null;
	}

	@Override
	public ArrayList<Employee> sort(Comparator<Employee> comparator) {
		
		return null;
	}

	
}
