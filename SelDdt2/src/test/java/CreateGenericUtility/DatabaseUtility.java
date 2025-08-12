package CreateGenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
    Connection con;
//	public void getDbConnection(String url,String UN,String Password) throws SQLException
//	{
//		try {
//		Driver d=new Driver();
//		DriverManager.registerDriver(d);
//		con=DriverManager.getConnection(url,UN,Password);
//		}catch(Exception e)
//		{
//		}
		public void getDbConnection()
		{
			try {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				con=DriverManager.getConnection("jsbc.mysql://localhost:3306/projects","root","root");
			}
			catch(Exception e) {}
		}
	
	public void closeDbConnection()
	{
		try {
			con.close();
		}catch(Exception e)
		{
		}
	}
	public  ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet result=null;
	 try{
		Statement s=con.createStatement();
		result=s.executeQuery(query);
	   }catch(Exception e) {}
		return result;
	   }
	public  int executeNonSelectQuery(String query) throws SQLException
	{
		int result=0;
	 try{
		Statement s=con.createStatement();
		result=s.executeUpdate(query);
	   }catch(Exception e) {}
		return result;
	   }
	
}
