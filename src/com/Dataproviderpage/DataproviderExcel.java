package com.Dataproviderpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataproviderExcel {
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet1;
	

	public DataproviderExcel(String excelpath) throws IOException {
		
		File scr =new File(excelpath);
		FileInputStream fis =new FileInputStream(scr);
		 wb= new XSSFWorkbook(fis);
		 sheet1=wb.getSheetAt(0);
				
	
	}
	public String  Testurl(int sheetno,int row,int coloumn)
	{
		String url=sheet1.getRow(row).getCell(coloumn).getStringCellValue();
		return url;
	}
   public String username1(int sheetno,int row,int column) {
	
	String username= sheet1.getRow(row).getCell(column).getStringCellValue();
	return username;
	   
   }
   public String password1(int sheetno,int row,int column) {
		
		String password= sheet1.getRow(row).getCell(column).getStringCellValue();
		return password;
	
}
   public int rowcount(int sheetindex)
   {
	   int row=wb.getSheetAt(sheetindex).getLastRowNum();
		row=row+1;
	   return row;
   }
}