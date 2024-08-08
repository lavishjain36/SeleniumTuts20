package com.seleniumfundamental.calenderframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderConcept {
	
	protected static String url="https://jqueryui.com/datepicker/";
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
	  public void handlecalender() throws InterruptedException {
		  //switch inside the frame
		  driver.switchTo().frame(0);
		  driver.findElement(By.id("datepicker")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@title='Next']")).click();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//table/tbody/tr/td/a[.='25']")).click();
		  
		  //capture the value and print in console same date selection
		  WebElement datelement=driver.findElement(By.id("datepicker"));
		  String date= datelement.getAttribute("value");
		  System.out.println("The selected date and month is  "+date);
		  
	  }
	  
	  @AfterSuite
		 public void closeChromeBrowser() {
			  driver.quit();
		 }
}
