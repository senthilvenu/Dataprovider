package config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public Properties pro;
	public Config() {
		try {
		File fp=new File("C:\\Users\\siva\\eclipse-workspace\\Dataprovider\\Data\\Config");
		FileInputStream fis=new FileInputStream(fp);
		 pro =new Properties();	
			pro.load(fis);
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public String chormepath() {
		String path =pro.getProperty("ChromeDriver");
		return path;
	
	}	*/
	
	/*public String BrowerDriver() {
		
		if(pro.getProperty("ChromeDriver").contains("ChromeDriver")) {
			System.getProperties()

		}
		
		return null;
		
		
	}*/
	
	public String excelpath() {
		
		String excelPath=pro.getProperty("ExcelPath");
		return excelPath;
	}
	
	}
