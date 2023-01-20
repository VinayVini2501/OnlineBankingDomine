package internet_banking;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.InternetBankingRigistrationPage;
public class InternetBankingRigisterTest extends BaseClass{
	@Test(groups= {"Smoke"})
	public void rigister() throws Throwable{
		Home_Page hp=new Home_Page(driver);
		hp.setInternetBanking(wLib, driver);
		
		InternetBankingRigistrationPage IBRP = new InternetBankingRigistrationPage(driver);
		IBRP.setInternetbankingRigistration(wLib, eLib, driver);
	}
}
