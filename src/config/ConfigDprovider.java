package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigDprovider {
	
	public Properties pro;

	public ConfigDprovider() throws IOException {
		
		File FDataprovider = new File("C:\\Users\\siva\\eclipse-workspace\\Dataprovider\\Data\\Config");
		
		FileInputStream fis= new FileInputStream(FDataprovider);
		
          pro=new Properties();
         pro.load(fis);
         
	}
	
	public String excelpath() {
		
		String excelp=pro.getProperty("Dataproviderpath");
		return excelp;
	}
}
