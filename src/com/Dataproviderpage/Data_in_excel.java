package com.Dataproviderpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_in_excel {
	
	public static Properties prop;
	
	public static void Exceldata() throws IOException
	{
		File f=new File("C:\\Users\\siva\\eclipse-workspace\\Dataprovider\\Data\\Config");
		FileInputStream fis=new FileInputStream(f);
		prop.load(fis);
		String exceldat=prop.getProperty("ExcelPath");
		XSSFWorkbook wb=new XSSFWorkbook(exceldat);
		int size=wb.getNumberOfSheets();
		
		
		
	}

}
