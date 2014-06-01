package company;

import java.util.ArrayList;

public interface IResource {
	
	void save(String path, ArrayList<Employee> empl);
	ArrayList<Employee> load(String path);
}
