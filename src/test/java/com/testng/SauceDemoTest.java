package com.testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {
	
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
		wd.findElement(By.id("password")).sendKeys(password);
		wd.findElement(By.id("login-button")).click();
		wd.findElement(By.id("react-burger-menu-btn")).click();
		wd.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass (alwaysRun = true)
	public void close() {
		wd.quit();
	}
}
