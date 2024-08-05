package com.seleniumfundamental.formwebelement;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class SubmitMethod {
 protected static String url="https://www.facebook.com/";
 WebDriver driver;
 
  @BeforeSuite
  public void startChromeBrowser() {
	  WebDriverManager.chromedriver().setup();//setup required initially.
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @Test
  public void submitFacebookMethod() throws InterruptedException {
	  driver.get(url);

	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("lavish@gmail.com");
	  
	  WebElement password=driver.findElement(By.id("pass"));
	  password.sendKeys("admin123");
	  
	  WebElement loginbtn=driver.findElement(By.name("login"));
	  loginbtn.submit();
//	  Thread.sleep(3000);
	  }

    @Test
    public void cleartextMethod() throws InterruptedException {
    	driver.get(url);
    	WebElement email=driver.findElement(By.id("emai"));
    	email.clear();
    	email.sendKeys("harini@gmail.com");
    	Thread.sleep(3000);
    	email.clear();
    	Thread.sleep(3000);
    }
  
  @AfterSuite
  public void closeChromeBrowser() {
	  driver.quit();
  }

}
