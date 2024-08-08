package com.seleniumfundamental.wait;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplcitiwaitConcept {
	 protected static String url="https://demoqa.com/automation-practice-form";
	 WebDriver driver;
	
	@BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  //global wait mechanism or implicit wait mechanism
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeMethod
	 public void openUrl() {
		  driver.get(url);
		  
	
	 }
	 
	 
  @Test
  public void f() {
  }
  
  @AfterSuite
	public void closeChromeBrowser(){
		  driver.quit();
	}
}
