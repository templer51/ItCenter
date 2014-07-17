package company.frames;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import company.entity.Employee;
import company.intefaces.ICompany;

public class FrameList extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JList<Employee> list = new JList<Employee>();
	
	private JButton btnFind = new JButton("Find");
	private JTextField inputSearch = new JTextField();
	
	private JButton btnDesc = new JButton("DESC");
	private JButton btnAsc = new JButton("ASC");
	
	private JLabel labelSortBy = new JLabel("Sort by: ");

	private String[] sortBy = {"Name", "Age", "Address", "Phone Number"};
	private JComboBox<String> boxSortBy = new JComboBox<String>(sortBy);
	
	private ICompany company = null;
	private DefaultListModel<Employee> listModel;

	public FrameList(ICompany company) throws HeadlessException {
		super();
		this.company = company;
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
		
		listModel = new DefaultListModel<Employee>();
		
		if (company.getEmployeeList() != null){
			for(Employee e : company.getEmployeeList()){
				listModel.addElement(e);
			}
		}
		
		list.setModel(listModel);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		btnFind.addActionListener(new FindClickAction());
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(list, BorderLayout.CENTER);
	}
	
	private class FindClickAction implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String value = inputSearch.getText();
			if (value.equals("")){
				return;
			}
			
			listModel.clear();
			List<Employee> findList = company.find(value);
			if (!findList.isEmpty()){
				for(Employee e : findList){
					listModel.addElement(e);
				}
			}
			
			list.setModel(listModel);
		}
		
	}
	
}
