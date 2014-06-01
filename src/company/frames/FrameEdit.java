package company.frames;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import company.datamodels.Employee;
import company.intefaces.ICompany;

public class FrameEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lName = new JLabel("Fullname:");
	private JLabel age = new JLabel("Age:");
	private JLabel address = new JLabel("Address:");
	private JLabel phone = new JLabel("Phone number:");
	
	private JTextField tName = new JTextField();
	private JTextField tAge = new JTextField();
	private JTextField tAddress = new JTextField();
	private JTextField tPhone = new JTextField();
	
	private JLabel message = new JLabel("");
	
	private JButton btn = new JButton("Save");
	private ICompany campany = null;
	private Employee employee;
	
	public FrameEdit(ICompany company, Employee employee) throws HeadlessException {
		super();
		this.campany = company;
		this.employee = employee;
		initFrame();
		setVisible(true);
	}
	
	public FrameEdit(ICompany company) throws HeadlessException {
		super();
		this.campany = company;
		initFrame();
		setVisible(true);
	}
	
	public void initFrame(){

		setSize(500, 150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Edit employee data");
		
		if (employee != null){
			tName.setText(employee.getLastName());
			tAddress.setText(employee.getAdress());
			tAge.setText(employee.getAge() + "");
			tPhone.setText(employee.getPhoneNumber());
		}
		
		JPanel panel = new JPanel();
		GroupLayout gLayout = new GroupLayout(panel);
		panel.setLayout(gLayout);
		
		GroupLayout.ParallelGroup hGroup = gLayout.createParallelGroup();
		
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(lName)
				.addComponent(tName));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(age)
				.addComponent(tAge));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(address)
				.addComponent(tAddress));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(phone)
				.addComponent(tPhone));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(btn));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(message));
		gLayout.setHorizontalGroup(hGroup);
	
		GroupLayout.SequentialGroup vGroup = gLayout.createSequentialGroup();

		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lName)
				.addComponent(tName));
		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(age)
				.addComponent(tAge));
		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(address)
				.addComponent(tAddress));
		vGroup.addGroup(gLayout.createParallelGroup()
				.addComponent(phone)
				.addComponent(tPhone));
		vGroup.addGroup(gLayout.createParallelGroup()
				.addComponent(btn));
		vGroup.addGroup(gLayout.createParallelGroup()
				.addComponent(message));
		gLayout.setVerticalGroup(vGroup);
		gLayout.linkSize(SwingConstants.VERTICAL, tName, tAge, tAddress, tPhone);
		gLayout.linkSize(SwingConstants.HORIZONTAL, lName, age, address, phone);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				clearError();
				
				String name = tName.getText();
				if (name.equals("")){
					setMessage("First name is required");
					return;
				}
				
				String ageString = tAge.getText();
				if (age.equals("")){
					setMessage("Inccorect value for age");
					return;
				}
				
				int age = 0;
				try{
					age = Integer.parseInt(ageString);
				} catch (NumberFormatException ex){
					setMessage(ex.getMessage());
					return;
				}
				if (age <= 18 || age >= 65){
					setMessage("Incorrect age");
					return;
				}
				
				String address = tAddress.getText();
				
				String phoneNumber = tPhone.getText();
				if (employee == null){
					Employee employee = new Employee(name, phoneNumber, age, address);
					campany.addEmployee(employee);
				} else {
					employee.updateEmployeeData(name, phoneNumber, age, address);
				}
				setMessage("Employee saved successfuly");
			}
		}); 
		
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	private void setMessage(String msg){
		message.setText(msg);
	}
	
	private void clearError(){
		message.setText("");
	}

}
