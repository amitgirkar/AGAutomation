package logger;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class FlipkartSearchTestLogger {
	
	Logger log;
	WebDriver wd;
	
	@BeforeClass
	public void launchBrowser() {
		log = LogManager.getLogger();
		wd = new ChromeDriver();
		log.info("user is opening Chrome brower");
		wd.get("https://www.flipkart.com/");
		log.info("user is being redirected to filpkart website");
	}
	
	String change;
	@Test(dataProviderClass = DataProvidr.class,dataProvider = "demo")
	public void search(String search) throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		log.info("user has searched product called as "+search+" and clicked on enter button");
		change = search;
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void screenShot() throws Exception {
		TakesScreenshot tss = (TakesScreenshot) wd;
		FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), new File("D:\\Amit G\\Automation\\Screenshots\\"+change+".png"));
		Thread.sleep(2000);
		wd.findElement(By.name("q")).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		log.info("after product got searched user has cleared search box");
	}
	
	@AfterClass
	public void close() throws Exception  {
		Thread.sleep(2000);
		wd.close();
		log.info("after searching the each product user has closed Chrome browser");
	}
}
