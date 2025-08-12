package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try
		{
			 Driver driverRef= new Driver();
			 DriverManager.registerDriver(driverRef);
			 con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
			 Statement stat=con.createStatement();
			 ResultSet r=stat.executeQuery("select * from project");
			 while(r.next())
			{
				System.out.println(r.getString(1)+ "\t" +r.getString(2)+ "\t" +r.getString(3)+"\t" +r.getString(4));
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Handle exception"); 
			
		}
		finally {
			 con.close();
			 System.out.println("================close the connection===========");
		}

	}

}
