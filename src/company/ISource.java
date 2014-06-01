package company;

import java.util.ArrayList;

public interface ISource {
	
	void save(String path, ArrayList<Employee> empl);
	ArrayList<Employee> load(String path);
}
