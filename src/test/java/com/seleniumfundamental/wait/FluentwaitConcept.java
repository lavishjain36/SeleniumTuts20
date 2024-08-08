package com.seleniumfundamental.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentwaitConcept {
	 protected static String url="https://demoqa.com/automation-practice-form";
	 WebDriver driver;
	
	@BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  //global wait mechanism or implicit wait mechanism
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	
	 }
	 @BeforeMethod
	 public void openUrl() {
		  driver.get(url);
		  
	
	 }
	 
	 
  @Test
  public void fluentwait() throws InterruptedException {
	  //create an object of FluentWait.
	  Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			  .withTimeout(Duration.ofSeconds(60))
			  .pollingEvery(Duration.ofSeconds(5))
			  .ignoring(NoSuchElementException.class);
	
	WebElement elementfield=wait.until(new Function<WebDriver,WebElement>(){
		   public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("firstName"));
		     }
	});
	  
	elementfield.sendKeys("Lavish");
	Thread.sleep(4000);
  }
  
  @AfterSuite
	public void closeChromeBrowser(){
		  driver.quit();
	}
}
