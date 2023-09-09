package com.myproject;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;





public class EditUser {

	public static WebElement add;
	public static WebElement city;
	private static XSSFWorkbook wb;
	public static WebElement cinfo;
	
	public  static WebDriver d;
	
	 public static void EditU() throws IOException 
	 
	 {
		 
		
	cinfo = d.findElement(By.linkText("//*[@id=\'leftPanel\']/ul/li[6]/a"));
			
		 cinfo.click(); 
		 
		 
		 File file = new File("C:\\Users\\Trupti\\parabankgit\\src\\test\\resources\\parabankdata.xlsx");
			
		    FileInputStream fis = new FileInputStream(file);
			
			wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheet("Sheet2");
			
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			
			for (int i = 1; i<=rowCount; i++)
			{
				int cellCount = sheet.getRow(i).getLastCellNum();
				
				for(int j =0; j<cellCount; j++)
				{
					
					String dt = sheet.getRow(i).getCell(j).getStringCellValue();
					
					if(j==0)
					{
						
							add = d.findElement(By.xpath("//*[@id=\'customer.address.street\']"));
							
							add.click();
							add.sendKeys(dt);
					}
						
						if(j==1)
						{
							city = d.findElement(By.xpath("//*[@id=\'customer.address.city\']"));
							city.click();
							city.sendKeys(dt); 
		 
		 
	 }
	 
	 }
	

	}
	 }
}


