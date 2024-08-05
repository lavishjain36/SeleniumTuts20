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

public class TableHeading {
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
	WebElement tableElement= driver.findElement(By.xpath("//table[@class='dataTable']/thead"));//iterating over thead
	List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
	 
	//use loop 
	 for(WebElement rowElement:rows) {
		List<WebElement> cells= rowElement.findElements(By.tagName("th"));
		for(WebElement cellElement:cells) {
			String celltext= cellElement.getText();
			System.out.print("|"+celltext+"|");
		}
		System.out.println();
	 }

	 }
	 @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }

}
