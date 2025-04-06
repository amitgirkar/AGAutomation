package com.testng;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrontAccountingAnnotation {
	
	WebDriver wd;
	int i = 1;
	
	@BeforeSuite
	public void LaunchBrowser() {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeTest
	public void OpenSite() {
		wd.get("https://demo.frontaccounting.eu/");
	}
	
	@BeforeClass
	public void Login() {
		wd.findElement(By.name("SubmitUser")).click();
	}
	
	@BeforeMethod
	public void SalesQuotationEntry() throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.linkText("Sales Quotation Entry")).click();
	}
	
	@Test
	public void CancelOrder() throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.name("CancelOrder")).click();
	}
	
	@Test
	public void Customer() throws Exception {
		Thread.sleep(2000);
		WebElement customer = wd.findElement(By.id("customer_id"));
		Select sct = new Select(customer);
		sct.selectByVisibleText("ABCD");
		Thread.sleep(2000);
		wd.findElement(By.name("CancelOrder")).click();
	}
	
	@Test
	public void Payment() throws Exception {
		Thread.sleep(2000);
		WebElement customer = wd.findElement(By.id("customer_id"));
		Select sct = new Select(customer);
		sct.selectByVisibleText("ABCD");
		Thread.sleep(2000);
		Select sct2 = new Select(wd.findElement(By.id("payment")));
		sct2.selectByVisibleText("Payment due within 10 days");
		Thread.sleep(2000);
		wd.findElement(By.name("CancelOrder")).click();
	}
	
	@AfterMethod
	public void mainPage() throws Exception {
		Thread.sleep(2000);
		Alert alt = wd.switchTo().alert();
		alt.accept();
		TakesScreenshot tss = (TakesScreenshot) wd;
		FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), new File("D:\\Amit G\\Automation\\FAAnnotation"+i+".png"));
		i++;
		Thread.sleep(2000);
		wd.findElement(By.linkText("Back")).click();
	}
	
	@AfterClass
	public void logout() throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest
	public void loginAgain() throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.linkText("Click here to Login Again.")).click();
	}
	
	@AfterSuite
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
