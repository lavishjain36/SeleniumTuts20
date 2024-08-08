package com.seleniumfundamental.scrolleffect;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToElement {
	
	protected static String url="https://www.amazon.com/";
	 WebDriver driver;
	
	 @BeforeSuite
	 public void startChromeBrowser() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  Thread.sleep(5000);

//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeClass
	 public void openUrl() {
		  driver.get(url);

	
	 }
	  @Test
	  public void scrolldown() throws InterruptedException {
		  JavascriptExecutor js= (JavascriptExecutor) driver;//type webDriver to javascriptExecutor
		  Thread.sleep(5000);
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//scrolldown
		  Thread.sleep(5000);
		  
		  js.executeScript("window.scrollTo(0,0)");//scroll up
		  Thread.sleep(3000);
	  }
  
  @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }

}
