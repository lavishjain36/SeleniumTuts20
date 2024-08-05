package com.seleniumfundamental.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {
  protected static String url="https://demo.guru99.com/test/simple_context_menu.html";
  WebDriver driver;
	  

  @BeforeSuite
  public void startChromeBrowser() {
      WebDriverManager.chromedriver().setup();//setup required initially.
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }
  
  @Test
  public void rightclickTest() throws InterruptedException {
	  driver.get(url);
	  Actions actions=new Actions(driver);
	  WebElement rightclickelement=driver.findElement(By.cssSelector(".context-menu-one"));
	  actions.contextClick(rightclickelement).perform();
	  Thread.sleep(3000);
	  WebElement copyelement=driver.findElement(By.cssSelector(".context-menu-icon-copy"));
	  copyelement.click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
  }
  
  
  @AfterSuite
  public void closeChromeBrowser() {
	  driver.quit();
  }
}
