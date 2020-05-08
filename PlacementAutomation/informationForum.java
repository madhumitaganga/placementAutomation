package allClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;

import sqliteConnectionn.dbConnection;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class informationForum {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informationForum window = new informationForum();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;

	/**
	 * Create the application.
	 */
	public informationForum() {
		connection = dbConnection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea(50, 50);
		textArea.setBounds(10, 10, 400, 303);
		frame.getContentPane().add(textArea);

		String query = "Select * from informationForum";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				textArea.append("\n" + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField = new JTextField();
		textField.setBounds(10, 337, 404, 68);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "insert into informationForum (message) values(?)";
				PreparedStatement pst;
				try {
					pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.execute();
					textArea.append("\n" + textField.getText());
					textField.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSend.setBounds(161, 415, 95, 29);
		frame.getContentPane().add(btnSend);

	}
}
