package internet_banking;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.InternetBankingLoginPage;
public class InternetBankingLoginTest extends BaseClass{
	@Test(groups= {"Smoke"})
	public void internetBankLogin() throws Throwable{
		Home_Page hp=new Home_Page(driver);
		hp.setLogin(wLib, driver);
		
		InternetBankingLoginPage IBLP = new InternetBankingLoginPage(driver);
		IBLP.setInternetLoginBankig(eLib, driver);
	}
}
