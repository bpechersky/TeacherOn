package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {

	WebDriver driver;
	
	Properties prop = new Properties();
	
	FileInputStream fis ;

	@BeforeClass
	public void initalization() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\properties\\config.properties");
		
		prop.load(fis);

		driver = new ChromeDriver();

		driver.get(prop.getProperty("Url"));

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void SelectDropdown()

	{
		// TODO Auto-generated method stub

		WebElement SelectDrpDown = driver.findElement(By.id(prop.getProperty("SelectDropDown_Id")));

		Select sel = new Select(SelectDrpDown);

		sel.selectByIndex(5);

		sel.selectByValue("search-alias=amazon-pharmacy");

		sel.selectByVisibleText("Appliances");

	}

	@Test(priority = 2)
	public void AdvanceDropdown() {

		WebElement SelectDrpDown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(SelectDrpDown);

		List<WebElement> li = sel.getOptions();
		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {

			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

	}

	@AfterClass
	public void cleanup() {
		driver.close();
	}

}
