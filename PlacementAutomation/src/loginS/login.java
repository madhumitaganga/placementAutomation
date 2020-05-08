package loginS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import allClasses.NewCompanyRegister;
import allClasses.NewStudentRegister;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textUsr;
	private JTextField textPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textUsr = new JTextField();
		textUsr.setBounds(165, 51, 215, 30);
		frame.getContentPane().add(textUsr);
		textUsr.setColumns(10);
		
		textPwd = new JTextField();
		textPwd.setBounds(165, 114, 215, 30);
		frame.getContentPane().add(textPwd);
		textPwd.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(21, 55, 85, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(21, 120, 85, 13);
		frame.getContentPane().add(lblPassword);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnStudent.setBounds(74, 183, 103, 21);
		frame.getContentPane().add(rdbtnStudent);
		
		JRadioButton rdbtnCompany = new JRadioButton("Company");
		rdbtnCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCompany.setBounds(277, 183, 103, 21);
		frame.getContentPane().add(rdbtnCompany);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnStudent.isSelected()) {
					
				}
				if(rdbtnCompany.isSelected()) {
					
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(165, 210, 103, 33);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewStudent = new JButton("New Student");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NewStudentRegister.main(null);
			}
		});
		btnNewStudent.setBounds(301, 10, 114, 21);
		frame.getContentPane().add(btnNewStudent);
		
		JButton btnNewCompany = new JButton("New Company");
		btnNewCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NewCompanyRegister.main(null);
			}
		});
		btnNewCompany.setBounds(177, 10, 114, 21);
		frame.getContentPane().add(btnNewCompany);
		
		JButton btnInformationForum = new JButton("Information Forum");
		btnInformationForum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInformationForum.setBounds(10, 10, 157, 21);
		frame.getContentPane().add(btnInformationForum);
	}
}
