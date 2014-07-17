package company.intefaces;

import java.util.Comparator;

public interface IComparator<T> {
	
	Comparator<T> getNameComparator();
	Comparator<T> getAgeComparator();
	Comparator<T> getAddresComparator();
	Comparator<T> getPhoneComparator();

}
