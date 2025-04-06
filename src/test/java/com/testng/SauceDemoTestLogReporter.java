package com.testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTestLogReporter {
	
	WebDriver wd;
	
	@BeforeClass (alwaysRun = true)
	public void browserLaunch() {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod (alwaysRun = true)
	public void openSite() {
		wd.get("https://www.saucedemo.com/");
	}
	
	@Test(dataProviderClass = DataProvdr.class,dataProvider = "login",alwaysRun = true)
	public void login(String username, String password) {
		wd.findElement(By.id("user-name")).sendKeys(username);
		Reporter.log("Username has been entered");
		wd.findElement(By.id("password")).sendKeys(password);
		Reporter.log("Password has been entered");
		wd.findElement(By.id("login-button")).click();
		Reporter.log("Clicked on Login button");
		wd.findElement(By.id("react-burger-menu-btn")).click();
		Reporter.log("Click on Side Menu button after login");
		wd.findElement(By.linkText("Logout")).click();
		Reporter.log("User logged out successful");
	}
	
	@AfterClass (alwaysRun = true)
	public void close() {
		wd.quit();
	}
}
