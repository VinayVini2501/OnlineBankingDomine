package open_Account;
import org.testng.annotations.Test;
import com.onlineBanking.genericutilities.BaseClass;
import com.onlineBanking.objectrepository.ConfirmAccountPage;
import com.onlineBanking.objectrepository.Home_Page;
import com.onlineBanking.objectrepository.OpenAccountPage;
public class OpenAccountTest extends BaseClass
{
	@Test
	public void OpenAccount() throws Throwable
	{
		Home_Page hp=new Home_Page(driver);
		hp.setOpenAccount();

		OpenAccountPage op =new OpenAccountPage(driver);
		op.setopenaccontpage(wLib);
		
		ConfirmAccountPage cap = new ConfirmAccountPage(driver);
		cap.setConfirmbutton(wLib, eLib, driver);
	}
}
