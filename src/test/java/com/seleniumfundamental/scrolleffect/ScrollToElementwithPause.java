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

public class ScrollToElementwithPause {
	
	protected static String url="https://the-internet.herokuapp.com/infinite_scroll";
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
		  for(int i=0;i<10;i++) {
			  JavascriptExecutor js= (JavascriptExecutor) driver;//type webDriver to javascriptExecutor
			  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//scrolldown
			  Thread.sleep(2000);  
		  }
		  	
	  }
  
  @AfterSuite
	 public void closeChromeBrowser() {
		  driver.quit();
	 }

}
