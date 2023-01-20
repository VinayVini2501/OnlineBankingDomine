package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_Data_Provider 
{
	@Test(dataProvider ="data")
	
	public void traval(String src, String dest, int Price)
	{
		System.out.println("from "+src+ "--------> "+dest+ Price);
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] objarr = new Object [3][3];
		
		objarr[0][0] = "Bengalore";
		objarr[0][1] = "Mysore";
		objarr[0][2] = 14;
		
		objarr[1][0] = "Mysore";
		objarr[1][1] = "Bengalore";
		objarr[1][2] = 10;
		
		objarr[2][0] = "Mysore";
		objarr[2][1] = "Bengalore";
		objarr[2][2] = 200;
		
		return objarr;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
