package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Read_data_from_database {

	public static void main(String[] args) throws SQLException 
	{
		Connection con1 = null;
		try
		{
		// Rigister the database
		Driver driver = new Driver();
		
		// Get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		
		// issue create the statement
		
		Statement state = con.createStatement();
		String query ="select * from studentInform;";
		
		//Execute query
		
		 ResultSet result = state.executeQuery(query);
		 
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		 }
	}
		catch(Exception e)
		{
			
		}
	finally
	{
		// close the database
		System.out.println("Close the database connection successfully");
	}
	
		
		
		
		

	}

}
