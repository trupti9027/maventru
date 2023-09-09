package com.myproject;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;


public class LoginPage {

	
	public static WebElement uname;
	public static WebElement pwd;
	public static WebElement lg;
	private static XSSFWorkbook wb;
	  public  static WebDriver d;
	
	public static void Launch() throws IOException 
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Seleniumtrupti\\chromedriver-win64.exe");
		WebDriverManager.chromedriver().setup();
		 ChromeOptions opt = new ChromeOptions();
		 opt.addArguments("--remote-allow-origins=*");
		 opt.addArguments("--disable-notification");  
		 d = new ChromeDriver(opt);
		 
		d =new ChromeDriver();
		d.manage().window().maximize();
		
		
		d.get("https://parabank.parasoft.com/parabank/register.htm");
		
		
		
File file = new File("C:\\Users\\Trupti\\parabankgit\\src\\test\\resources\\parabankdata.xlsx");
		
	    FileInputStream fis = new FileInputStream(file);
		
		wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for (int i = 1; i<=rowCount; i++)
		{
			int cellCount = sheet.getRow(i).getLastCellNum();
			
			for(int j =0; j<cellCount; j++)
			{
				
				String dt = sheet.getRow(i).getCell(j).getStringCellValue();
				
				if(j==0)
				{
					
						uname = d.findElement(By.xpath("//*[@id=\'loginPanel\']/form/div[1]/input"));
						
						uname.click();
						uname.sendKeys(dt);
				}
					
					if(j==1)
					{
						pwd = d.findElement(By.xpath("//*[@id=\'loginPanel\']/form/div[2]/input"));
						pwd.click();
						pwd.sendKeys(dt);
					
					
					
					
					WebElement lg =d.findElement(By.xpath("//*[@id=\'loginPanel\']/form/div[3]/input"));
					lg.click();
					}
		
	}


}
	}
}