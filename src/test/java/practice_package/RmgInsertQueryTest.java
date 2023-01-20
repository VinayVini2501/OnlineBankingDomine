package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RmgInsertQueryTest {

	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		int result =0;
		try
		{
			Driver driver= new  Driver();
			// Rigister the database

			DriverManager.registerDriver(driver);

			// connection for the database
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			// issue create the statement

			Statement state = con.createStatement();
			String query ="insert into project values('TY_Project_0061','Vinay','21/12/22','sdet45','Created',3);";

			// Update the query

			result = state.executeUpdate(query);
		}
		catch(Exception e)
		{
         e.printStackTrace();
		}
		finally
		{
			if(result==1)
			{
				System.out.println("Data inserted successfully");	
			}
			else
			{
				System.out.println("Data not inserted ");
			}
			
			//Close the database
			con.close();//this will give the sql exception
			System.out.println("close the database connection successfully");
		}
		
		
	

	}

}
