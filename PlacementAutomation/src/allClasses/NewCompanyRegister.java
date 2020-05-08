package allClasses;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import loginS.login;
import sqliteConnectionn.dbConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewCompanyRegister {

	private JFrame frame;
	private JTextField cIDField;
	private JTextField nameTextField;
	private JTextField noOfCanTextField;
	private JTextField textField;
	public static int CID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCompanyRegister window = new NewCompanyRegister();
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
	public NewCompanyRegister() {
		initialize();
		connection=dbConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewStudentRegistration = new JLabel("New Company Registration");
		lblNewStudentRegistration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewStudentRegistration.setBounds(119, 10, 189, 31);
		frame.getContentPane().add(lblNewStudentRegistration);
		
		JLabel lblCompanyid = new JLabel("CompanyId");
		lblCompanyid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompanyid.setBounds(32, 131, 96, 31);
		frame.getContentPane().add(lblCompanyid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(32, 198, 96, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblNumberOfCandidates = new JLabel("Number of Candidates");
		lblNumberOfCandidates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfCandidates.setBounds(32, 278, 170, 31);
		frame.getContentPane().add(lblNumberOfCandidates);
		
		JLabel lblField = new JLabel("Field");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblField.setBounds(32, 356, 170, 31);
		frame.getContentPane().add(lblField);
		
		cIDField = new JTextField();
		cIDField.setBounds(225, 131, 163, 27);
		frame.getContentPane().add(cIDField);
		cIDField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setText("");
		nameTextField.setBounds(225, 198, 163, 27);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		noOfCanTextField = new JTextField();
		noOfCanTextField.setText("");
		noOfCanTextField.setBounds(225, 282, 163, 27);
		frame.getContentPane().add(noOfCanTextField);
		noOfCanTextField.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(225, 356, 163, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="insert into company values(?,?,?,?)";
				CID =Integer.parseInt(cIDField.getText());
				try {
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,cIDField.getText());
					pst.setString(2,nameTextField.getText());
					pst.setString(3,noOfCanTextField.getText());
					pst.setString(4,textField.getText());
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
					createCompany.main(null);
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(143, 440, 141, 31);
		frame.getContentPane().add(btnContinue);
	}

}
