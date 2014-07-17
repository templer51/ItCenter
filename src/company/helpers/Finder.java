package company.helpers;

import java.util.ArrayList;
import java.util.List;

import company.intefaces.IEmployee;
import company.intefaces.IFinder;

public class Finder<T extends List<V>, V> implements IFinder<T>{

	@SuppressWarnings("unchecked")
	public T find(T list, String value) {
		
		T result = (T) new ArrayList<V>();
		
		IEmployee item = null;
		for(V a : list){
			item = (IEmployee) a;
			if (item.getLastName().contains(value) ||
				Integer.toString(item.getAge()).contains(value) ||
				item.getAdress().contains(value) ||
				item.getPhoneNumber().contains(value)){
				result.add(a);
			}
		}
		
		return result;
	}

}
