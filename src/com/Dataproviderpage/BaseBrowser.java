package com.Dataproviderpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseBrowser {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public static WebDriver initializedriver() throws IOException
	{
		File f= new File("C:\\Users\\siva\\eclipse-workspace\\Dataprovider\\Data\\Config");
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
	    prop.load(fis);
		String Browser=prop.getProperty("Browsername");
		System.out.println(Browser);
		
		if(Browser.equals("chrome")) {
			//System.getenv()
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse-committers-oxygen-1a-win32-x86_64\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();	
			
		}
		
		else if(Browser.equals("IE")){
			
            System.setProperty("webdriver.ie.driver", "C:\\eclipse-committers-oxygen-1a-win32-x86_64\\Selenium\\IEDriverServer_64\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		
		return driver;
	}


}
