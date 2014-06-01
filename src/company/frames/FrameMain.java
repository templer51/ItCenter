package company.frames;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import company.Company;
import company.intefaces.ICompany;

public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button1 = new JButton("List Of Employee");
	private JButton button2 = new JButton("Add Employee");
	ICompany company = new Company();

	public FrameMain() throws HeadlessException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setTitle("Compay navigation");
		init();
		setVisible(true);
	}

	public void init() {

		button2.addActionListener(new AddButtonListener());
		button1.addActionListener(new ListButtonListener());
		
		JPanel panel = new JPanel();
		GroupLayout gLayout = new GroupLayout(panel);
		panel.setLayout(gLayout);
		
		GroupLayout.ParallelGroup hGroup = gLayout.createParallelGroup();
		
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(button1));
		hGroup.addGroup(gLayout.createSequentialGroup()
				.addComponent(button2));
		gLayout.setHorizontalGroup(hGroup);
	
		GroupLayout.SequentialGroup vGroup = gLayout.createSequentialGroup();

		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(button1));
		vGroup.addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(button2));
		gLayout.setVerticalGroup(vGroup);
		
		gLayout.linkSize(SwingConstants.HORIZONTAL, button1, button2);

		getContentPane().add(panel, BorderLayout.CENTER);

	}

	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new FrameEdit(company);
		}

	}
	
	private class ListButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new FrameList();
		}

	}
}
