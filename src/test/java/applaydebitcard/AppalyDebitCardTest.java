package applaydebitcard;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.ApplayDebitCardPage;
import com.onlineBanking.objectrepository.Home_Page;
public class AppalyDebitCardTest extends BaseClass{
	@Test(groups= {"Smoke"})
	public void applayDebitcard() throws Throwable
	{
		Home_Page hp=new Home_Page(driver);
		hp.setApplayDebitCard();
		
		ApplayDebitCardPage ADCP = new ApplayDebitCardPage(driver);
		ADCP.setApplaydebitcard(wLib, eLib, driver);	
	}
}
