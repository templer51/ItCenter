package company;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ServiceCentreFrame extends JFrame {

	private JButton button1 = new JButton("List Of Employee");
	private JButton button2 = new JButton("Add Employee");
	Company company = new Company();

	public ServiceCentreFrame() throws HeadlessException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		init();
		setVisible(true);
	}

	public void init() {

		GridLayout midGL = new GridLayout(2, 1);
		JPanel midPanel = new JPanel(midGL);

		midPanel.add(button1);
		midPanel.add(button2);
		button2.addActionListener(new AddButtonListener());
		button1.addActionListener(new ListButtonListener());

		getContentPane().add(midPanel, BorderLayout.CENTER);
		
		

	}

	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new EditFrame(company);
			
		}

	}
	
	private class ListButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new MyNewJList();
			
		}

	}

}
