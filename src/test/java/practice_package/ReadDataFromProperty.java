package practice_package;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromProperty {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String Username = p.getProperty("username");
		String password = p.getProperty("password");
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(Username);
		System.out.println(password);
		

	}

}
