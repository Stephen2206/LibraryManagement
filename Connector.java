import java.sql.*;

import javax.swing.JOptionPane;
public class Connector 
{
		Connection c4=null;
		public static Connection db4()
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection c4=DriverManager.getConnection("jdbc:sqlite:C:\\LibraryManagement.sqlite");
				JOptionPane.showMessageDialog(null, "Connected to the AB Database");
				return c4;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
		}

				
}
