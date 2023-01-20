package internet_banking;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.AddBenificiaryPage;
import com.onlineBanking.objectrepository.FundTransferPage;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.InternetBankingLoginPage;
import com.onlineBanking.objectrepository.MyProfilePage_CustomerProfilePage;
public class FundTransferTest extends BaseClass
{
	@Test(groups= {"Regression"})
	public void fundTransfer() throws Throwable
	{
		Home_Page hp=new Home_Page(driver);
		hp.setLogin(wLib, driver);
		
		InternetBankingLoginPage IBLP = new InternetBankingLoginPage(driver);
		IBLP.setInternetLoginBankig(eLib, driver);
		
		MyProfilePage_CustomerProfilePage CPP = new MyProfilePage_CustomerProfilePage(driver);
		CPP.FundTransfer();
		
		FundTransferPage FTP = new FundTransferPage(driver);
		FTP.AddBeneficiary();
		
		AddBenificiaryPage ABP = new AddBenificiaryPage(driver);
		ABP.setAddBenificiaryPage(eLib, driver, wLib);
		
		hp.setFundTranfer();
		FTP.setSelectBenificiary(wLib, driver);	
	}
}
