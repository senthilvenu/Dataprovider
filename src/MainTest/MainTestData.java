package MainTest;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.Dataproviderpage.GmailLoginPage;
//import Papajohns.OnlineOrdersCashPay;

public class MainTestData {

	WebDriver driver;
	public String username;
	public String password;	
	public String TestFlag;
	public String url;
	private static Logger log=LogManager.getLogger(MainTestData.class.getName());
			
	@Test
	public void Gmail() throws InterruptedException, IOException {
		 	
			GmailLoginPage login =new GmailLoginPage();
			log.info("Scenario Executed Surcessfully"); 
			login.GmailLogin(TestFlag,url,username, password);
		    log.info("Scenario Executed Surcessfully"); 						
			}
	
	}
