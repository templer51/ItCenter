package company;

import java.util.Comparator;

public interface ICompany {
	void find(Comparator<Employee> c);
	void sort(Comparator<Employee> c);
}
