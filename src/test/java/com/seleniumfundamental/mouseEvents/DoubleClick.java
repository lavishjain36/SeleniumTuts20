package com.seleniumfundamental.mouseEvents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {
	protected static String url="https://demo.guru99.com/test/simple_context_menu.html";
	   WebDriver driver;
	  

	  @BeforeSuite
	  public void startChromeBrowser() {
	      WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  
	  }
	  
	  
	  @Test
	  public void doubleclickTest() throws InterruptedException {
		  driver.get(url);
		  Actions action=new Actions(driver);
		  WebElement buttonelement=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		  action.doubleClick(buttonelement).perform();
		  Thread.sleep(3000);
		  //switch to alert box
		  Alert al=driver.switchTo().alert();
		  System.out.println("Alert text "+ al.getText());
		  al.accept();
		  Thread.sleep(1000);
		  
	  }
	  
	  
	  
	  @AfterSuite
	  public void closeChromeBrowser() {
		  driver.quit();
	  }
}
