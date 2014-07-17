package company.comparators;

import java.util.Comparator;

import company.entity.Employee;

public class NameComparator implements Comparator<Employee>{

	private String search;
	
	public NameComparator(String search){
		this.search = search;
	}
	
	public int compare(Employee employee1, Employee employee2) {
		if(employee1.getLastName().contains(search)){
			return 1;
		}
		return 0;
	}
	
}
