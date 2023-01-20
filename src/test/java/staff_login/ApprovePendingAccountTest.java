package staff_login;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.Pending_Customerpage;
import com.onlineBanking.objectrepository.StaffHomePage;
import com.onlineBanking.objectrepository.StaffLoginPage;
public class ApprovePendingAccountTest extends BaseClass{
	@Test(groups= {"Smoke"})
	public void ApprovePendingAccount() throws Throwable
	{
		Home_Page hp=new Home_Page(driver);
		hp.setStaffLogin();

		StaffLoginPage stflpage = new StaffLoginPage(driver);
		stflpage.setStaffid(fLib, fLib.readDataFromPropertyFile("StaffId"), fLib.readDataFromPropertyFile("Password1"));

		StaffHomePage sthome = new StaffHomePage(driver);
		sthome.ApprovePendingAccount();

		Pending_Customerpage pcp = new Pending_Customerpage(driver);
		pcp.PendingCustomerPage(driver, eLib, wLib);
	}
}
