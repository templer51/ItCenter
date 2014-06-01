package company;

import java.util.ArrayList;
import java.util.Comparator;

public interface ICompany {
	Employee find(Comparator<Employee> comparator);
	ArrayList<Employee> sort(Comparator<Employee> comparator);
}