package com.seleniumfundamental.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickandHold {
	 protected static String url="https://www.tutorialspoint.com/selenium/practice/menu.php#";
	   WebDriver driver;
	  

	  @BeforeSuite
	  public void startChromeBrowser() {
	      WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  
	  }
	  
	  @BeforeClass
	  public void openUrl() {
		  driver.get(url);
	  }
	  
	  @Test
	  public void clickandholdTest() throws InterruptedException {
		  driver.get(url);
		  WebElement navbar=driver.findElement(By.linkText("Navbar"));
		  
		  String beforecolor=navbar.getCssValue("color");
		  System.out.println("rgba code format "+beforecolor);
		  Thread.sleep(2000);
		  
		  //create an object Actions class
		  Actions action=new Actions(driver);
		  action.clickAndHold(navbar).build().perform();
		  Thread.sleep(3000);
		  
		  String aftercolor=navbar.getCssValue("color");
		  System.out.println("rgba code format "+aftercolor);
	  }
	  
	  @AfterSuite
	  public void closeChromeBrowser() {
		  driver.quit();
	  }
}
