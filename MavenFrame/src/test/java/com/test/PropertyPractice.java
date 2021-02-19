package com.test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;





public class PropertyPractice {
	
	Properties prop = new Properties();

	FileInputStream fis ;
	
	
	
  @Test
  public void f() throws IOException, InterruptedException {
	  
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\properties\\myconfig.properties");
		
		prop.load(fis);
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get(prop.getProperty("mypracticeurl"));
		
		
		driver.manage().window().maximize();
		
		WebElement features = driver.findElement(By.xpath("featuresmenu"));
		
		
		Actions act = new Actions(driver);
		
			
		
	    WebElement hotelfeatures = driver.findElement(By.xpath("//a[text()='Hotels Module']"));
	    
	   // act.moveToElement(features).perform();
		act.moveToElement(features).moveToElement(hotelfeatures).click().build().perform();
	    
		
	
		driver.quit();
		
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

}
