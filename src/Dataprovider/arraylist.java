package Dataprovider;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Dataproviderpage.Excelsheet;

public class arraylist {

	public static Excelsheet excl;
	public static void main(String[] args) {	
		
		
   ArrayList obj=new ArrayList();        
    int size=obj.size();    
    for(int i=0;i<size;i++)
    {    
    System.out.println(obj.get(i));
	}
}
}