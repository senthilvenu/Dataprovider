package MainTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestExcel {	
	
	@Test	
	public static void getdata() throws IOException
	{
		
	System.out.println("Testing Started");	
	//File file=new File();
	FileInputStream fis=new FileInputStream("C:\\Users\\siva\\eclipse-workspace\\Dataprovider\\Data\\Data.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	int size= wb.getActiveSheetIndex();
	for(int i=0;i<size;i++ )
	{ // For loop open
	XSSFSheet sh=wb.getSheetAt(i);	
	if(sh.getSheetName().equalsIgnoreCase("PIJData")) { // if sheet name open
		Iterator<Row> row=sh.rowIterator();
		Row firstrow=row.next();
		Iterator<Cell> ce= firstrow.cellIterator();
		int k=0;
		int column = 0;
		while(ce.hasNext()) { // While loop open for cell name
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("Testcase")) // If for cell string value
			{
				column=k;
             
		}// if for Cell sting closed
			k++;
				}// While loop closed cell name
		System.out.println(column);
		
		while(row.hasNext())// while loop open for row
			
		{
			Row val=row.next();
			if(val.getCell(column).getStringCellValue().equalsIgnoreCase("Carryout")) {  // If open for row 
			
				Iterator<Cell> cv=val.cellIterator();
				
				while(cv.hasNext()) {   // while loop open for available of first row column
					
				// a.add(cv.next().getStringCellValue());
					System.out.println(cv.next().getStringCellValue());
					
				}// While loop closed row
			} // if closed for row
			
		}// hasnext closed  
			} 
		
	
	}	
	//return a;
	
	}
	
}