package sqliteConnectionn;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class dbConnection {
	Connection conn=null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\madhu\\eclipse-workspacenew\\PlacementA.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection is successful!");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
