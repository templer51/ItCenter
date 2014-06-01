package company;
import java.util.ArrayList;
import java.util.Comparator;

public class Company implements ICompany{
	
	ArrayList<Employee> employees = new ArrayList<>();
	
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
	public void find(Comparator<Employee> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort(Comparator<Employee> c) {
		// TODO Auto-generated method stub
		
	}
	
}