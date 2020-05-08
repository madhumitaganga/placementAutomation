package allClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import loginS.login;
import sqliteConnectionn.dbConnection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class createStudent {

	private JFrame frame;
	private JTextField textUsr;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public String USN=NewStudentRegister.USN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createStudent window = new createStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the application.
	 */
	public createStudent() {
		initialize();
		connection=dbConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(200, 200, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create A New Account");
		lblCreateANew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCreateANew.setBounds(127, 24, 181, 27);
		frame.getContentPane().add(lblCreateANew);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(46, 151, 125, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(46, 242, 125, 27);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(46, 326, 144, 27);
		frame.getContentPane().add(lblConfirmPassword);
		
		textUsr = new JTextField();
		textUsr.setBounds(221, 149, 144, 27);
		frame.getContentPane().add(textUsr);
		textUsr.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(221, 245, 144, 25);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(221, 328, 144, 25);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!((passwordField.getText()).equals(passwordField_1.getText()))) {
					JOptionPane.showMessageDialog(null, "Passwords do not match!");
				}
				else {
					String query="insert into studentAcc (usn,usr,pwd) values(?,?,?)";
					try {
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,USN);
						pst.setString(2,textUsr.getText());
						pst.setString(3,passwordField.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Entry Successful!");
						try {
							connection.close();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Oops! Something went wrong");
							frame.setVisible(false);
							login.main(null);
						}
						frame.setVisible(false);
						login.main(null);
				} catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(146, 412, 144, 27);
		frame.getContentPane().add(btnSubmit);
	}
}
