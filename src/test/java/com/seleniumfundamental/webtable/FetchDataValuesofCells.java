package com.seleniumfundamental.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataValuesofCells {
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
	 public void getcellValueofRowandColumn() {
		 WebElement tableRow=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		String rowtext= tableRow.getText();
		System.out.println("Third row of table "+rowtext);
		
		WebElement cellvalue3col=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[3]"));
		String valueofcell=cellvalue3col.getText();
		System.out.println(valueofcell);
	 }

	 
	 @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }


}
