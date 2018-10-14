package com.Dataproviderpage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import config.Config;

public class GmailLoginPage extends BaseBrowser {

	//public WebDriver driver;
	public static Config chromepath;
	public Excelsheet excl;
	public String username;
	public String password;
	public String url;
	public String Testflag;
	public String usern = "c:\\test\\screen\\username.png";
	public String Pwd = "c:\\test\\screen\\pwd.png";
	public void GmailLogin(String TestFlag,String url,String username,String password) throws InterruptedException, IOException {
					
		//chromepath =new Config();
		driver=initializedriver();
		Config excelpath=new Config();
		excl=new Excelsheet(excelpath.excelpath());
		int rowcount=excl.rowcount(0);		
		for(int i=1;i<rowcount;i++) {
			Testflag=excl.Testflag(0, i, 0);
			url =excl.Testurl(0, i, 1);
			username = excl.username1(0, i, 2);	
			password = excl.password1(0, i, 3);	
			//System.setProperty("webdriver.chrome.driver",chromepath.chormepath());
			//driver =new ChromeDriver();
			if(Testflag.contains("Gmail")) {	
				driver.get(url);
				String url2 =driver.getCurrentUrl();
				System.out.println(url2);
				String title= driver.getTitle();
				System.out.println(title);		
				//JavascriptExecutor js =(JavascriptExecutor)driver;
				driver.findElement(By.name("identifier")).sendKeys(username);
				//js.executeScript("document.getElementByName('identifier').value=username;");
				TakesScreenshot ts= (TakesScreenshot)driver;
				File scr=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File(usern));				
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				File Pwd1= ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Pwd1, new File(Pwd));
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(5000);			
				WebElement element=driver.findElement(By.xpath("//content[contains(text(),'Welcome')]//following::input[3]"));
				Actions act=new Actions(driver);
				act.moveToElement(element).sendKeys(password).build().perform();			
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				/*String email= driver.findElement(By.xpath("//span[@id=' :3d']")).getText();
				String[] ar=email.split(" ");	
				System.out.println("Email id : " + ar[3]);	*/				
				driver.findElement(By.xpath("//span[@class='gb_8a gbii']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
				/*	String Pwndow= driver.getWindowHandle();
				driver.switchTo().window(Pwndow);				
				Set<String> allwindow = driver.getWindowHandles();
				Iterator<String> allwindows= allwindow.iterator();
				String ParentWindow = allwindows.next();
				driver.switchTo().window(ParentWindow);
				String childWindow= allwindows.next();
				driver.switchTo().window(childWindow);*/
				//softassertion.assertAll();
				/*Select sel = new Select(driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")));
				sel.selectByVisibleText("Test");
				sel.selectByIndex(1);	*/
				/*Actions act1=new Actions(driver);
				act1.dragAndDrop(source, target)*/
				//SoftAssert softassertion=new SoftAssert();
				//softassertion.assertEquals(username, "senthiltestng");	
				//WebDriverWait wait=new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
				driver.quit();
				
			} else if(Testflag.contains("ymail")) {
				driver.get(url);
				System.out.println("yahoo mail launched sucessfully");
				driver.quit();
				
							
			}
								
						}
							
	}
	
	}
