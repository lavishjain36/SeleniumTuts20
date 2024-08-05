package com.seleniumfundamental.keyboardevents;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class KeyboardEvents {
   protected static String url="https://demoqa.com/text-box";
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
  public void fetchtitle() throws InterruptedException {
	  String title=driver.getTitle();
	  System.out.println(title);
	  Thread.sleep(1000);
  }
  
  
   @Test
   public void getkeyboardEvent() throws InterruptedException {
	   //create the object of Actions Class
	   
	   Actions actions=new Actions(driver);
	   //enter the username
	   WebElement fullName=driver.findElement(By.id("userName"));
	   fullName.sendKeys("Lavish Jain");
	   
	   //enter the email
	   WebElement email=driver.findElement(By.id("userEmail"));
	   email.sendKeys("lavish@gmail.com");
	   
	   //enter the current address
	   WebElement currentAddress=driver.findElement(By.id("currentAddress"));
	   currentAddress.sendKeys("Hinjewadi Phase-1,Pune");
	   
	   //select the current address CTRL+A
	   actions.keyDown(Keys.CONTROL);
	   actions.sendKeys("a");
	   actions.keyUp(Keys.CONTROL);
	   actions.build().perform();
	   
	   
	   //copy the current addrss->CTRL+C
	   actions.keyDown(Keys.CONTROL);
	   actions.sendKeys("c");
	   actions.keyUp(Keys.CONTROL);
	   actions.build().perform();
	   
	   
	   //Press tab key to 
	   actions.sendKeys(Keys.TAB);
	   actions.build().perform();
	   
	   
	   //paste the address in permanent address using CTRL+V
	   actions.keyDown(Keys.CONTROL);
	   actions.sendKeys("v");
	   actions.keyUp(Keys.CONTROL);
	   actions.build().perform();
	   
	   
	   //compare text of current address and permanent address  
	   WebElement permanentAdress=driver.findElement(By.id("permanentAddress"));
	 
	   assertEquals(currentAddress.getAttribute("value"), permanentAdress.getAttribute("value"));
	   
   }
  
 

  @AfterSuite
  public void closeChromeBrowser() {
	  driver.quit();
  }

}
