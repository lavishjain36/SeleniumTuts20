package com.seleniumfundamental.scrolleffect;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown {
	
	protected static String url="https://www.amazon.com/";
	 WebDriver driver;
	
	 @BeforeSuite
	 public void startChromeBrowser() throws InterruptedException {
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
	  public void scrolltoelement() throws InterruptedException {
		
		  JavascriptExecutor js= (JavascriptExecutor) driver;//type webDriver to javascriptExecutor
		
		  WebElement elementlocator=driver.findElement(By.xpath("//div[starts-with(text(),'Make Money with Us')]"));
		  js.executeScript("arguments[0].scrollIntoView(true)",elementlocator);
		  Thread.sleep(3000);
		  
		  //write your script from here
	  }
  
//  @AfterSuite
//	 public void closeChromeBrowser() {
//		  driver.quit();
//	 }

}
