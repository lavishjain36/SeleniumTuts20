package com.seleniumfundamental.formwebelement;

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

public class SelectRadioButton {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
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
	 public void radioButton() throws InterruptedException {
		 WebElement radiobtnmale=driver.findElement(By.xpath("//input[@id='gender']"));
		 radiobtnmale.click();
		 
		 //need to verify if button selected
		 boolean result=radiobtnmale.isSelected();
		 System.out.println(result);
		 Thread.sleep(3000);
		
	 }
	 
	 
	 @Test
	 public void radioButtonGroup() throws InterruptedException {
		List<WebElement> totalradiobtns=driver.findElements(By.xpath("//input[@type='radio']"));
		int count=totalradiobtns.size();
		System.out.println("Total number of radio buttons are "+ count);
		
		//click on all button one by one->forEach loop
		for(WebElement el:totalradiobtns) {
			if(!el.isSelected()) {
				el.click();
			}
		}
		Thread.sleep(2000);
	 }
	 
	 @AfterSuite
	  public void closeChromeBrowser() {
		  driver.quit();
	  }
	  
}
