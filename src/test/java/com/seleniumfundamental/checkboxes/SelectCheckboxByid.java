package com.seleniumfundamental.checkboxes;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class SelectCheckboxByid {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
	 WebDriver driver;
 @BeforeSuite
  public void startChromeBrowser() {
	 WebDriverManager.chromedriver().setup();//setup required initially.
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }
  @BeforeClass
  public void openUrl() {
	  driver.get(url);

  }


  @Test
  public void checkboxById() throws InterruptedException {
//	  WebElement checkboxelement=driver.findElement(By.id("hobbies"));
	  WebElement checkboxelement=driver.findElement(By.xpath("//input[@id='hobbies']"));
	  checkboxelement.click();
	  Thread.sleep(2000);
  }
  
  
  @AfterSuite
  public void closeChromeBrowser() {
	  driver.quit();
  }

}
