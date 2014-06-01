package company;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class MyNewJList extends JFrame {
	private JList<Employee> list = new JList<>();

	public void myJList() {
		
		// JFrame frame = new JFrame("Employees List");
		// frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ArrayList<Employee> list1 = MySaver.load();
		DefaultListModel<Employee> listModel = new DefaultListModel<>();
		
		for(Employee e : list1){
			listModel.addElement(e);
		}
		
		list.setModel(listModel);

		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		getContentPane().add(list);
		
	}

	public MyNewJList() throws HeadlessException {
		super();
		myJList();
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
