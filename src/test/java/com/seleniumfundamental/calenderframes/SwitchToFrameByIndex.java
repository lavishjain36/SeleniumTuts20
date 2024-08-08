package com.seleniumfundamental.calenderframes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrameByIndex {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/frames.php";
	 WebDriver driver;
	
	 @BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeClass
	 public void openUrl() {
		  driver.get(url);
	
	 }
	 
	 @Test
	 public void getframeByIndex() {
		//switch to frame
		 driver.switchTo().frame(1);//index
//		 driver.switchTo().frame("idname")//switch by using id
		 WebElement text=driver.findElement(By.xpath("//*[.='Selenium - Automation Practice Form']"));
		 System.out.println(text.getText());
	 }
	 
	 
	  @AfterSuite
		 public void closeChromeBrowser() {
			  driver.quit();
		 }

}
