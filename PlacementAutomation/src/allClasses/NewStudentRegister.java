package allClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import loginS.login;
import sqliteConnectionn.dbConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class NewStudentRegister {

	private JFrame frame;
	public static String date;
	private JTextField textUsn;
	private JTextField textName;
	private JTextField textGname;
	private JTextField textDept;
	private JTextField textCgpa;
	private JTextField textExtra;
	private JTextField textNoofback;
	public static String USN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentRegister window = new NewStudentRegister();
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
	public NewStudentRegister() {
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
		
		JLabel lblNewStudentRegistration = new JLabel("New Student Registration");
		lblNewStudentRegistration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewStudentRegistration.setBounds(119, 10, 189, 31);
		frame.getContentPane().add(lblNewStudentRegistration);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsn.setBounds(38, 81, 78, 31);
		frame.getContentPane().add(lblUsn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(38, 134, 78, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(38, 192, 96, 31);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblCgpa = new JLabel("CGPA");
		lblCgpa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCgpa.setBounds(38, 359, 96, 31);
		frame.getContentPane().add(lblCgpa);
		
		JLabel lblGuardianName = new JLabel("Guardian Name");
		lblGuardianName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGuardianName.setBounds(38, 243, 123, 31);
		frame.getContentPane().add(lblGuardianName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepartment.setBounds(38, 300, 96, 31);
		frame.getContentPane().add(lblDepartment);
		
		JLabel lblExtraCurriculars = new JLabel("Extra Curriculars");
		lblExtraCurriculars.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExtraCurriculars.setBounds(38, 411, 146, 31);
		frame.getContentPane().add(lblExtraCurriculars);
		
		JLabel lblNumberOfBacklogs = new JLabel("Number of Backlogs");
		lblNumberOfBacklogs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfBacklogs.setBounds(38, 466, 146, 31);
		frame.getContentPane().add(lblNumberOfBacklogs);
		
		textUsn = new JTextField();
		textUsn.setBounds(246, 81, 134, 24);
		frame.getContentPane().add(textUsn);
		textUsn.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(246, 140, 134, 24);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textGname = new JTextField();
		textGname.setColumns(10);
		textGname.setBounds(246, 251, 134, 24);
		frame.getContentPane().add(textGname);
		
		textDept = new JTextField();
		textDept.setColumns(10);
		textDept.setBounds(246, 308, 134, 24);
		frame.getContentPane().add(textDept);
		
		textCgpa = new JTextField();
		textCgpa.setColumns(10);
		textCgpa.setBounds(246, 367, 134, 24);
		frame.getContentPane().add(textCgpa);
		
		textExtra = new JTextField();
		textExtra.setColumns(10);
		textExtra.setBounds(246, 419, 134, 24);
		frame.getContentPane().add(textExtra);
		
		textNoofback = new JTextField();
		textNoofback.setColumns(10);
		textNoofback.setBounds(246, 474, 134, 24);
		frame.getContentPane().add(textNoofback);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(246, 199, 134, 24);
		frame.getContentPane().add(dateChooser);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="insert into student values(?,?,?,?,?,?,?,?)";
				try {
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textUsn.getText());
					USN=textUsn.getText();
					pst.setString(2,textName.getText());
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					date=sdf.format(dateChooser.getDate());
					pst.setString(3,date);
					pst.setString(4,textGname.getText());
					pst.setString(5,textDept.getText());
					pst.setString(6,textCgpa.getText());
					pst.setString(7,textExtra.getText());
					pst.setString(8,textNoofback.getText());
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
					createStudent.main(null);
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(156, 518, 108, 24);
		frame.getContentPane().add(btnContinue);
	}
}
