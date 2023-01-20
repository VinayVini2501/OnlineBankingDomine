package practice_package;

import org.testng.annotations.Test;

public class Retry_Test
{
	@Test(retryAnalyzer = com.onlineBanking.genericutilities.RetryImplimentation.class)
	public void sample()
	{
		
	}

}
