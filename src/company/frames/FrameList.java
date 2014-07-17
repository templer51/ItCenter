package company.frames;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
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
import company.helpers.CompanyComparator;
import company.helpers.Fields;
import company.helpers.SortDirection;
import company.intefaces.ICompany;
import company.intefaces.IComparator;
import company.intefaces.IEmployee;

public class FrameList extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JList<Employee> list = new JList<Employee>();
	
	private JButton btnFind = new JButton("Find");
	private JTextField inputSearch = new JTextField();
	
	private JButton btnDesc = new JButton("DESC");
	private JButton btnAsc = new JButton("ASC");
	
	private JLabel labelSortBy = new JLabel("Sort by: ");

	private Fields[] sortBy = Fields.values();
	private JComboBox<Fields> boxSortBy = new JComboBox<Fields>(sortBy);
	
	private ICompany company = null;
	private DefaultListModel<Employee> listModel;
	
	private SortDirection direction = SortDirection.ASC;

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

		btnAsc.setEnabled(false);
		btnAsc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				direction = SortDirection.ASC;
				btnAsc.setEnabled(false);
				btnDesc.setEnabled(true);
				sort();
			}
		});
		
		btnDesc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				direction = SortDirection.DESC;
				btnAsc.setEnabled(true);
				btnDesc.setEnabled(false);
				sort();
			}
		});
		boxSortBy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				sort();
			}
		});
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(list, BorderLayout.CENTER);
		
		sort();
	}
	
	private class FindClickAction implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String value = inputSearch.getText();
			
			listModel.clear();
			List<Employee> findList = company.find(value);
			if (!findList.isEmpty()){
				for(Employee e : findList){
					listModel.addElement(e);
				}
			}
			
			list.setModel(listModel);
			sort();
		}
		
	}
	
	private void sort(){
		int index = boxSortBy.getSelectedIndex();
		if (index <= -1 || index >= sortBy.length){
			return;
		}
		
		Fields field = sortBy[index];
		
		List<Employee> employees = Collections.list(listModel.elements());
		
		IComparator<IEmployee> comparator = new CompanyComparator(direction);
		if (field == Fields.NAME){
			Collections.sort(employees, comparator.getNameComparator());
		} else if (field == Fields.AGE){
			Collections.sort(employees, comparator.getAgeComparator());
		} else if (field == Fields.ADDRESS){
			Collections.sort(employees, comparator.getAddresComparator());
		} else if (field == Fields.PHONE){
			Collections.sort(employees, comparator.getPhoneComparator());
		}
		
		listModel.clear();
		if (!employees.isEmpty()){
			for(Employee e : employees){
				listModel.addElement(e);
			}
		}
		
		list.setModel(listModel);
	}
	
}
