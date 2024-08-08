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

public class SwitchToFrameByName {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/nestedframes.php";
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
	 public void getFrameByWebElement() {
		WebElement iframeidelement=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeidelement);//web element to frame as argument.
		WebElement text=driver.findElement(By.xpath("//*[starts-with(text(),'Selenium -')]"));
		System.out.println(text.getText());
		
		//once you are frame , you can't access
//		outside element 
		driver.switchTo().defaultContent();
		
		//navigate another frame.
		WebElement outsideframe=driver.findElement(By.xpath("//*[.='Nested Frames']"));
		System.out.println(outsideframe.getText());//NestedFrame
	 }
	 
	 
	  @AfterSuite
		 public void closeChromeBrowser() {
			  driver.quit();
		 }

}
