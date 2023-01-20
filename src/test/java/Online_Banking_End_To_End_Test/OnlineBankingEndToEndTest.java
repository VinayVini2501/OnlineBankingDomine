package Online_Banking_End_To_End_Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.AddBenificiaryPage;
import com.onlineBanking.objectrepository.ApplayDebitCardPage;
import com.onlineBanking.objectrepository.ConfirmAccountPage;
import com.onlineBanking.objectrepository.CreditCustomerPage;
import com.onlineBanking.objectrepository.CustomerDetailsPage;
import com.onlineBanking.objectrepository.FundTransferPage;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.InternetBankingLoginPage;
import com.onlineBanking.objectrepository.InternetBankingRigistrationPage;
import com.onlineBanking.objectrepository.MyProfilePage_CustomerProfilePage;
import com.onlineBanking.objectrepository.OpenAccountPage;
import com.onlineBanking.objectrepository.Pending_Customerpage;
import com.onlineBanking.objectrepository.StaffHomePage;
import com.onlineBanking.objectrepository.StaffLoginPage;
import com.onlineBanking.objectrepository.View_Active_CustomerPage;

public class OnlineBankingEndToEndTest extends BaseClass
{
	public void onlineBankingEndToEnd() throws Throwable
	{
		Home_Page hp=new Home_Page(driver);
		hp.setOpenAccount();

		OpenAccountPage op =new OpenAccountPage(driver);
		op.setopenaccontpage(wLib);

		ConfirmAccountPage cap = new ConfirmAccountPage(driver);
		cap.setConfirmbutton(wLib, eLib, driver);
	
		hp.setStaffLogin();

		StaffLoginPage stflpage = new StaffLoginPage(driver);
		stflpage.setStaffid(fLib, fLib.readDataFromPropertyFile("StaffId"), fLib.readDataFromPropertyFile("Password1"));

		StaffHomePage sthome = new StaffHomePage(driver);
		sthome.ApprovePendingAccount();

		Pending_Customerpage pc = new Pending_Customerpage(driver);
		pc.PendingCustomerPage(driver, eLib, wLib);

		View_Active_CustomerPage Vac = new View_Active_CustomerPage(driver);
		Vac.Staffhome();

		sthome.ViewActiveCustomer1();
		sthome.Home();
		
		sthome.ViewCustomerByAccountNumber();

		CustomerDetailsPage Cdp = new CustomerDetailsPage(driver);
		Cdp.CustomerDetails(driver, eLib);

		CreditCustomerPage ccp = new CreditCustomerPage(driver);
		sthome.CreditCustomer();
		ccp.CreditCustomerPage1(wLib, eLib, driver);

		hp.setHomepage();
		hp.setApplayDebitCard();

		ApplayDebitCardPage ADCP =new ApplayDebitCardPage(driver);
		ADCP.setApplaydebitcard(wLib, eLib, driver);
		hp.setHomepage();

		hp.setInternetBanking(wLib, driver);

		InternetBankingRigistrationPage IBRP = new InternetBankingRigistrationPage(driver);
		IBRP.setInternetbankingRigistration(wLib, eLib, driver);
		hp.setHomepage();

		hp.setLogin(wLib, driver);

		InternetBankingLoginPage IBLP = new InternetBankingLoginPage(driver);
		IBLP.setInternetLoginBankig(eLib, driver);

		MyProfilePage_CustomerProfilePage MP = new MyProfilePage_CustomerProfilePage(driver);
		MP.FundTransfer();
		
		FundTransferPage FTP = new FundTransferPage(driver);
		FTP.AddBeneficiary();
		
		AddBenificiaryPage ABP = new AddBenificiaryPage(driver);
		ABP.setAddBenificiaryPage(eLib, driver, wLib);
		MP.FundTransfer();
		
		FTP.setSelectBenificiary(wLib, driver);
	}
}
