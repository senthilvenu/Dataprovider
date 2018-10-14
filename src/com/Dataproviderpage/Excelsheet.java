package com.Dataproviderpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelsheet {
	
	public   XSSFWorkbook wb;
	public   XSSFSheet sheet;
		 
	
	public  Excelsheet(String excelpath) throws IOException
	
	
	{
		File scr=new File(excelpath);
		FileInputStream Fis =new FileInputStream(scr);
		 wb = new XSSFWorkbook(Fis);
		 sheet = wb.getSheetAt(0);			
				
	}
	public String  Testflag(int sheetno,int row,int coloumn)
	{
		String TestFlag=sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return TestFlag;
	}
	public String  Testurl(int sheetno,int row,int coloumn)
	{
		String url=sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return url;
	}
	public String  username1(int sheetno,int row,int coloumn)
	{
		String username=sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return username;
	}
	public String  password1(int sheetno,int row,int coloumn)
	{
		String password=sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return password;
	}
	
	public int rowcount(int sheetindex) {
		
		int row=wb.getSheetAt(sheetindex).getLastRowNum();
		row=row+1;
		return row;
		
	}
	
}
