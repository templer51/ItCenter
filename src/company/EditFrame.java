package company;
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

public class EditFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lName = new JLabel("Fullname:");
	private JLabel age = new JLabel("Age:");
	private JLabel address = new JLabel("Address:");
	private JLabel phone = new JLabel("Phone number:");
	
	private JTextField tName = new JTextField();
	private JTextField tAge = new JTextField();
	private JTextField tAddress = new JTextField();
	private JTextField tPhone = new JTextField();
	
	private JButton btn = new JButton("Save");
	Company campany = null;

	public EditFrame(Company company) throws HeadlessException {
		super();
		setSize(500, 150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		initFrame();
		this.campany = company;
		setVisible(true);
	}
	
	public void initFrame(){

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
		gLayout.setVerticalGroup(vGroup);
		gLayout.linkSize(SwingConstants.VERTICAL, tName, tAge, tAddress, tPhone);
		gLayout.linkSize(SwingConstants.HORIZONTAL, lName, age, address, phone);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tName.getText();
				int age = Integer.parseInt(tAge.getText());
				String address = tAddress.getText();
				String phoneNumber = tPhone.getText();
				Employee employee = new Employee(name, phoneNumber, age, address);
				campany.addEmployee(employee);
			}
		}); 
		
		getContentPane().add(panel, BorderLayout.CENTER);
	}

}
