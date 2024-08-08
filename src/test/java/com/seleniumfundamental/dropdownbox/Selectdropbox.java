package com.seleniumfundamental.dropdownbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectdropbox {
	 protected static String url="https://demoqa.com/select-menu";
	 WebDriver driver;
	 @BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeClass
	 public void openUrl() {
		  driver.get(url);
	
	 }
//	  @Test
//	  public void selectByIndex() throws InterruptedException {
//		  WebElement selectelement=driver.findElement(By.id("oldSelectMenu"));
//		  //create an object of Select class
//		  Select select=new Select(selectelement);
////		  select.selectByIndex(4);
////		  select.selectByValue("8");
//		  select.selectByVisibleText("Green");
//		  Thread.sleep(3000);
//		  select.deselectByVisibleText("Green");
//		  Thread.sleep(3000);
//
//	  }
	 
	  //List of all options in dropdown
	 @Test
	 public void listofalloptions() throws InterruptedException {
		  WebElement selectelement=driver.findElement(By.id("oldSelectMenu"));
		  Select select=new Select(selectelement);
		  //list of all element
		List<WebElement> elements= select.getOptions();
		
		//iterate over list ->using loop mechanism
		for(WebElement options:elements) {
			System.out.println(options.getText());
			Thread.sleep(3000);
		}
		  
	 }
  
	  @AfterSuite
		 public void closeChromeBrowser() {
			  driver.quit();
		 }
}
