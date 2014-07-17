package company.intefaces;

import java.util.List;

import company.helpers.Fields;

public interface IFinder<T extends List<?>> {

	T find(T list, String value);
	
}
