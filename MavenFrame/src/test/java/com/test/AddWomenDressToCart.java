package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddWomenDressToCart {
	
	
	
	Properties prop = new Properties();
	
	FileInputStream fis ;
	
	@Test
	public void AddDressToShoppingCart() throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\properties\\config.properties");
		
		prop.load(fis);
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("http://automationpractice.com/index.php");
		
		driver.get(prop.getProperty("Practiceurl"));
		
		
		driver.manage().window().maximize();
		
		//WebElement Women = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		
		WebElement Women = driver.findElement(By.xpath(prop.getProperty("title")));
		Actions act = new Actions(driver);
		
		act.moveToElement(Women).perform();
		
		driver.findElement(By.xpath("(//a[text()='Summer Dresses'])[2]")).click();


		WebElement tshirt = driver.findElement(By.xpath("(//img[@title=\"Printed Summer Dress\"])[2]"));
//		act.moveToElement(tshirt).perform();
//		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
//		String totalPrice = driver.findElement(By.xpath("//td[@id='total_price_container']")).getText();
//		System.out.println("total price is " + totalPrice);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("a[title='Contact Us']")).click();
		

//		Thread.sleep(3000);
//		WebElement SelectDrpDown = driver.findElement(By.id("id_contact"));
//	
//		Select sel = new Select(SelectDrpDown);
//		
//		sel.selectByVisibleText("Customer service");
		
		driver.quit();
	}
	

}
