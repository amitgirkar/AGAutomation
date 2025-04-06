package com.testng;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartSearchTest {
	
	WebDriver wd;
	
	@BeforeClass
	public void launchBrowser() {
		wd = new ChromeDriver();
		wd.get("https://www.flipkart.com/");
	}
	
	String change;
	@Test(dataProviderClass = DataProvdr.class,dataProvider = "demo")
	public void search(String search) throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		change = search;
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void screenShot() throws Exception {
		TakesScreenshot tss = (TakesScreenshot) wd;
		FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), new File("D:\\Amit G\\Automation\\Screenshots\\"+change+".png"));
		Thread.sleep(2000);
		wd.findElement(By.name("q")).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
	}
	
	@AfterClass
	public void close() throws Exception  {
		Thread.sleep(2000);
		wd.close();
	}
}
