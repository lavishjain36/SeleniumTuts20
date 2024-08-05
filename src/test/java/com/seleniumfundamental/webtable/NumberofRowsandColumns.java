package com.seleniumfundamental.webtable;

import java.time.Duration;
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

public class NumberofRowsandColumns {
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
	 public void testnumberofrowsandcolumns() {
	 List<WebElement> col= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));

	 System.out.println("No of columns "+ col.size());
	 
	 List<WebElement> row=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	 System.out.println("No of rows "+row.size());
	 }
	 @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }

}
