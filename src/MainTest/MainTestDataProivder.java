package MainTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dataproviderpage.DataproviderExcel;
import com.Dataproviderpage.Excelsheet;

import config.Config;
import config.ConfigDprovider;


public class MainTestDataProivder {

	WebDriver driver;
	public String username;
	public String password;
	public DataproviderExcel excl;
	public int row;
	public String TestFlag;
	public Config chromepath;
	public String url;
			
	@Test(dataProvider="gmaildata")	
	public void GmailLogin(String url,String username,String password ) throws InterruptedException, IOException 
	{
		
		chromepath =new Config();		
		//int rowcount=excl.rowcount(0);			
			/*System.setProperty("webdriver.chrome.driver",chromepath.chormepath());
			driver =new ChromeDriver();*/
			driver.get(url);									
				driver.findElement(By.name("identifier")).sendKeys(username);
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(5000);			
				WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]//following::input[3]"));
				Actions act=new Actions(driver);
				act.moveToElement(element).sendKeys(password).build().perform();			
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				String email= driver.findElement(By.xpath("//span[@id=':3d']")).getText();
				String[] ar=email.split(" ");		
				System.out.println("Email id : " + ar[3]);						
				driver.findElement(By.xpath("//a[@class='gb_b gb_fb gb_R']")).click();
				driver.findElement(By.xpath("//a[@id='gb_71']")).click();
				driver.quit();
		
		}

	
	@DataProvider(name="gmaildata")	
	public Object[][] gmaildatails() throws IOException
	{
		ConfigDprovider excelpath1=new ConfigDprovider();
		excl=new DataproviderExcel(excelpath1.excelpath());
		row = excl.rowcount(0);
		System.out.println("Last row:"+row);	  		
		Object[][] data=new Object[row][3];	
		//ArrayList obj=new ArrayList();
		for(int i=0;i<row;i++)
		{
		data[i][0]=excl.Testurl(0, i, 0);
		data[i][0]=excl.username1(0, i, 1);
		data[i][1]=excl.password1(0, i, 2);				
		}
		return data;
	}
		
}
