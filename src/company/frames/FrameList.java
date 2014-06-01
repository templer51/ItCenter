package company.frames;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import company.datamodels.Employee;
import company.sources.MySaver;

public class FrameList extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JList<Employee> list = new JList<>();
	
	private JButton btnFind = new JButton("Find");
	private JTextField inputSearch = new JTextField();
	
	private JButton btnDesc = new JButton("DESC");
	private JButton btnAsc = new JButton("ASC");
	
	private JLabel labelSortBy = new JLabel("Sort by: ");

	private String[] sortBy = {"Name", "Age", "Address", "Phone Number"};
	private JComboBox<String> boxSortBy = new JComboBox<>(sortBy);

	public FrameList() throws HeadlessException {
		super();
		myJList();
		setSize(600, 600);
		setTitle("Staff");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void myJList() {
		
		JPanel panel = new JPanel();
		GroupLayout gLayout = new GroupLayout(panel);
		panel.setLayout(gLayout);
		
		GroupLayout.ParallelGroup hGroup = gLayout.createParallelGroup();
		
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(inputSearch)
				.addComponent(btnFind));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(labelSortBy)
				.addComponent(boxSortBy)
				.addComponent(btnDesc)
				.addComponent(btnAsc));
		gLayout.setHorizontalGroup(hGroup);
	
		GroupLayout.SequentialGroup vGroup = gLayout.createSequentialGroup();

		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(inputSearch)
				.addComponent(btnFind));
		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(labelSortBy)
				.addComponent(boxSortBy)
				.addComponent(btnDesc)
				.addComponent(btnAsc));
		gLayout.setVerticalGroup(vGroup);
		
		ArrayList<Employee> list1 = MySaver.load();
		DefaultListModel<Employee> listModel = new DefaultListModel<>();
		
		for(Employee e : list1){
			listModel.addElement(e);
		}
		
		list.setModel(listModel);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(list, BorderLayout.CENTER);
	}
}
