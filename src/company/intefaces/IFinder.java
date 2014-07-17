package company.intefaces;

import java.util.List;

public interface IFinder<T extends List<?>> {

	T find(T list, String value);
	
}
