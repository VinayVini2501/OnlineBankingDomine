package com.onlineBanking.genericutilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
public class DatabaseUtility
{
	Connection con = null;
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstantants.DBURL, IPathConstantants.DBUSERNAME, IPathConstantants.DBPASSWORD);
	}
	public String executeQueryAndgetData(String query, int columnINdex, String expData) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String data = result.getString(columnINdex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData)) //comparing
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"project is created");
			return expData;
		}
		else
		{
			System.out.println("Project is not created");
			return " ";
		}
	}
	 public void closeDB() throws Throwable
	 {
		 con.close();
	 }
}
