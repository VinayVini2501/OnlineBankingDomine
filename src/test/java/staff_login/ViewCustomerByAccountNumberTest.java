package staff_login;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.CustomerDetailsPage;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.StaffHomePage;
import com.onlineBanking.objectrepository.StaffLoginPage;
public class ViewCustomerByAccountNumberTest extends BaseClass
{
	@Test(groups= {"Regression"})
	public void ViewCustomerByAccNo() throws Throwable{
		Home_Page hp=new Home_Page(driver);
		hp.setStaffLogin();

		StaffLoginPage stflpage = new StaffLoginPage(driver);
		stflpage.setStaffid(fLib, fLib.readDataFromPropertyFile("StaffId"), fLib.readDataFromPropertyFile("Password1"));
		
		StaffHomePage sthome = new StaffHomePage(driver);
		
		sthome.ViewCustomerByAccountNumber();
	
		CustomerDetailsPage cdp = new CustomerDetailsPage(driver);
		cdp.CustomerDetails(driver, eLib);
	}
}
