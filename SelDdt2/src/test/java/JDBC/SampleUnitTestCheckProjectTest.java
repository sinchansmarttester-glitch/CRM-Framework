package JDBC;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SampleUnitTestCheckProjectTest {
@Test
public void projectTest() throws SQLException
{
	String expectedProjectName="FB_01";
	boolean flag=false;
	 com.mysql.jdbc.Driver driverRef= new com.mysql.jdbc.Driver();
	 DriverManager.registerDriver(driverRef);
	 Connection con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
	 Statement stat=con.createStatement();
	 ResultSet r=stat.executeQuery("select * from emp");
	 while(r.next())
	{
		String actProjectName=r.getString(4);
		if(expectedProjectName.equals(actProjectName))
		{
			flag=true;
			System.out.println(expectedProjectName+"is available==PASS");
		}
	}
	 if(flag==false)
	 {
		 System.out.println(expectedProjectName+"is not available==FAIL"); 
	 }
	 con.close();
}
}
