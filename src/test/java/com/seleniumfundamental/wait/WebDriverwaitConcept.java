package com.seleniumfundamental.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverwaitConcept {
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
  public void explicitWait() throws InterruptedException {
	  //create the object of the WebDriverWait
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	  
	  WebElement firstnamefield=driver.findElement(By.id("firstName"));
	  firstnamefield.sendKeys("Lavish");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	  WebElement lastnamefield=driver.findElement(By.id("lastName"));
	  lastnamefield.sendKeys("Jain");	 
	  
	  WebElement submitbtn=driver.findElement(By.id("submit"));

	  //locate button using scroll effect 
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true)", submitbtn);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
	  submitbtn.click();
	  
	 
	  
	  Thread.sleep(5000);
  }
  
  @AfterSuite
	public void closeChromeBrowser(){
		  driver.quit();
	}
}
