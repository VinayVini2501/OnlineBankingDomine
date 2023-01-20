package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Login_Rmg
{
	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		Connection con = null;
		String project_name="Bdomine1";
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("http://rmgtestingserver:8084/");

			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[.='Projects']")).click();

			driver.findElement(By.xpath("//span[.='Create Project']")).click();

			driver.findElement(By.name("projectName")).sendKeys(project_name);


			Thread.sleep(2000);

			driver.findElement(By.name("createdBy")).sendKeys("Vinayy");

			WebElement Pstatus = driver.findElement(By.xpath("//label[.='Project Status ']/../select[@name='status']"));
			Select s = new Select(Pstatus);
			s.selectByVisibleText("Created");

			driver.findElement(By.xpath("//input[@value='Add Project']")).click();

			//connect database

			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con =DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects\", \"root@%\", \"root");

			Statement state= con.createStatement();

			String query ="select * from  project;";

			ResultSet result = state.executeQuery(query);

			boolean flag =false;
			while(result.next())
			{
				String actualProject = result.getString(4);
				System.out.println(actualProject);

				if(actualProject.equalsIgnoreCase(project_name))
				{
					flag=true;
					break;
				}

			}
			if(flag)
			{
				System.out.println("Project is created Successfully");
			}
			else {
				
					System.out.println("Project is not created");
				}
			}

		catch (Exception e) 
		{
			e.printStackTrace();

		}
		finally
		{
			con.close();
			System.out.println("Data base is Closed");
			
		}



















	}

}
