package practice_package;

import org.testng.annotations.Test;

public class PracticeTestNgTest
{
	@Test()
	public void create()
	{
		System.out.println("Created");
	}
	
	@Test(invocationCount = 2)
	 public void update()
	 {
		System.out.println("Updated");
	 }
	
	@Test()
	 public void delete()
	 {
		System.out.println("Deleted");
	 }

}
