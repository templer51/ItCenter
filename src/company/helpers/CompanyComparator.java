package company.helpers;

import java.util.Comparator;

import company.intefaces.IComparator;
import company.intefaces.IEmployee;

public class CompanyComparator implements IComparator<IEmployee> {

	private SortDirection direction;
	
	public CompanyComparator(SortDirection direction){
		this.direction = direction;
	}
	
	public Comparator<IEmployee> getNameComparator() {
		return new Comparator<IEmployee>() {
			
			public int compare(IEmployee arg0, IEmployee arg1) {
				if (direction == SortDirection.ASC){
					return arg0.getLastName().compareTo(arg1.getLastName());
				} else if (direction == SortDirection.DESC){
					return arg1.getLastName().compareTo(arg0.getLastName());
				}
				return 0;
			}
			
		};
	}

	public Comparator<IEmployee> getAgeComparator() {
		return new Comparator<IEmployee>() {

			public int compare(IEmployee arg0, IEmployee arg1) {
				if (direction == SortDirection.ASC){
					return arg0.getAge() - arg1.getAge();
				} else if (direction == SortDirection.DESC){
					return arg1.getAge() - arg0.getAge();
				}
				return 0;
			}
			
		};
	}

	public Comparator<IEmployee> getAddresComparator() {
		return new Comparator<IEmployee>() {
			
			public int compare(IEmployee arg0, IEmployee arg1) {
				if (direction == SortDirection.ASC){
					return arg0.getAdress().compareTo(arg1.getAdress());
				} else if (direction == SortDirection.DESC){
					return arg1.getAdress().compareTo(arg0.getAdress());
				}
				return 0;
			}
			
		};
	}

	public Comparator<IEmployee> getPhoneComparator() {
		return new Comparator<IEmployee>() {
			
			public int compare(IEmployee arg0, IEmployee arg1) {
				if (direction == SortDirection.ASC){
					return arg0.getPhoneNumber().compareTo(arg1.getPhoneNumber());
				} else if (direction == SortDirection.DESC){
					return arg1.getPhoneNumber().compareTo(arg0.getPhoneNumber());
				}
				return 0;
			}
			
		};
	}



}
