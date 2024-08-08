package com.seleniumfundamental.alertconcept;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertConcept {
	 protected static String url="https://demoqa.com/alerts";
	 WebDriver driver;
	@BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeMethod
	 public void openUrl() {
		  driver.get(url);
	
	 }
	  @Test
	  public void acceptAlert() throws InterruptedException {
		  WebElement alertbtn=driver.findElement(By.id("alertButton"));
		  alertbtn.click();	  
		  Thread.sleep(2000);
		  
		  Alert al=driver.switchTo().alert();
		  al.accept();
		  Thread.sleep(2000);
		  System.out.println("Accept Alert");
	 }
	  
	  @Test
	  public void dismissAlert() throws InterruptedException {
		  WebElement alertbtn=driver.findElement(By.id("alertButton"));
		  alertbtn.click();	  
		  Thread.sleep(2000);
		  
		  Alert al=driver.switchTo().alert();
		  al.dismiss();
		  Thread.sleep(2000);
		 System.out.println("Dismiss Alert");
	 }
	  
	  
	  @Test
	  public void gettext() throws InterruptedException {
		  WebElement alertbtn=driver.findElement(By.id("alertButton"));
		  alertbtn.click();	  
		  Thread.sleep(2000);
		  
		  Alert al=driver.switchTo().alert();
		  System.out.println(al.getText());
		  al.accept();
		  Thread.sleep(2000);
		 System.out.println("Gettext of the  Alert box");
	  }
	  
	  
	  @Test
	  public void acceptconfirmAlert() throws InterruptedException {
		  WebElement confirmboxbtn=driver.findElement(By.id("confirmButton"));
		  confirmboxbtn.click();
		  Thread.sleep(2000);
		  Alert al=driver.switchTo().alert();
		  al.accept(); 
		  Thread.sleep(1000);
		  System.out.println("Accept confirm alert...");

	  }
	  
	  @Test
	  public void dismissconfirmAlert() throws InterruptedException {
		  WebElement confirmboxbtn=driver.findElement(By.id("confirmButton"));
		  confirmboxbtn.click();
		  Thread.sleep(2000);
		  Alert al=driver.switchTo().alert();
		  al.dismiss(); 
		  Thread.sleep(1000);
		  System.out.println("Dismiss confirm alert...");

	  }
	  
	  @Test
	  public void acceptPromptalert() throws InterruptedException {
		  WebElement promptbtn=driver.findElement(By.id("promtButton"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click()", promptbtn);
		  Thread.sleep(2000);
		  Alert al=driver.switchTo().alert();
		  al.sendKeys("Lavish");
		  al.accept();
		  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void dismissPromptalert() throws InterruptedException {
		  WebElement promptbtn=driver.findElement(By.id("promtButton"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click()", promptbtn);
		  Thread.sleep(2000);
		  Alert al=driver.switchTo().alert();
		  al.dismiss();
		  Thread.sleep(2000);
	  }
	    @AfterSuite
		public void closeChromeBrowser(){
			  driver.quit();
		}
}
