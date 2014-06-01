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
