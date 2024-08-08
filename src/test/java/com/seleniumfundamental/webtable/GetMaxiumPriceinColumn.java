package com.seleniumfundamental.webtable;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMaxiumPriceinColumn {
	protected static String url="https://demo.guru99.com/test/web-table-element.php#";
	 WebDriver driver;
	@BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeClass
	 public void openUrl() {
		  driver.get(url);
	
	 }
	 
	 @Test
	 public void getMaxiumPriceincolumn() throws ParseException {
		 String max;
		 double  m=0,max_currentprice=0;
		 //no of columns and print size
		 List<WebElement> cols= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
         System.out.println("No of columns "+ cols.size());
		 
		 //no of rows and print the size
         List<WebElement> rows=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
    	 System.out.println("No of rows "+rows.size());
    	 
    	 //iterate over for loop -for rows
    	 for(int i=1;i<rows.size();i++) {
    		 max=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[4]")).getText();
//    		 System.out.println(max);
    		 NumberFormat f=NumberFormat.getNumberInstance();
    		 Number num=f.parse(max);
    		 max= num.toString();
    		 m=Double.parseDouble(max);
    		 if(m>max_currentprice) {
    			 max_currentprice=m;
    		 }
    	 }
    	 
    	 System.out.println("Maximum Current price "+max_currentprice);
    	 
	 }
	 
	 //get the minimum price.
	 
	 
	 
	 
	 @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }
}
