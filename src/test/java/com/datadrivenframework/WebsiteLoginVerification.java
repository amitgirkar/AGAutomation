package com.datadrivenframework;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WebsiteLoginVerification {

	public static void main(String[] args) throws Exception {
		// Website Login Verification
		
		WebDriver cd = new ChromeDriver();
		cd.get("https://abyss.to/");
		
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(4);
		for (int i=1; i<=sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell pass = row.getCell(1);
			TimeUnit.SECONDS.sleep(2);
			try {
				cd.findElement(By.partialLinkText("Log in")).click();
			} catch (Exception e) {
			
			}
			TimeUnit.SECONDS.sleep(2);
			cd.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(email.toString());
			TimeUnit.SECONDS.sleep(2);
			cd.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys(pass.toString());
			TimeUnit.SECONDS.sleep(2);
			cd.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
			TimeUnit.SECONDS.sleep(2);
			cd.findElement(By.cssSelector("button.btn.btn-primary.btn-block")).click();
			TimeUnit.SECONDS.sleep(2);
			try {
				cd.findElement(By.partialLinkText("Logout")).click();
			} catch (Exception e) {
				TakesScreenshot tss = (TakesScreenshot) cd;
				FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), new File("D:\\Amit G\\Automation\\eclipse-workspace\\SeleniumAutomation\\Screenshots\\"+email.toString()+"_"+pass.toString()+".png"));
				cd.navigate().refresh();
			}				
		}
	}
}
