package com.keyworddrivenframework;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class KDFSauceDemo {

	public static void main(String[] args) throws Exception {
		// Key Driven Framework
		WebDriver cd = new ChromeDriver();
		cd.get("https://www.saucedemo.com/");
		RepoSauceDemo r = new RepoSauceDemo(cd);
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("SwagLabs");
		for (int i = 1; i <=10; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell testSteps = row.getCell(0);
			switch (testSteps.toString()) {
			case "Enter username and password" :
				Thread.sleep(2000);
				r.username("standard_user");
				Thread.sleep(2000);
				r.password("secret_sauce");
				break;
			case "Click on Login button" :
				Thread.sleep(2000);
				r.login();
				break;
			case "Click on Add to Cart" :
				Thread.sleep(2000);
				r.addToCart();
				break;
			case "Go to Cart" :
				Thread.sleep(2000);
				r.goToCart();
				break;
			case "Click on Checkout button" :
				Thread.sleep(2000);
				r.checkout();
				break;
			case "Enter Firstname, Lastname and Postalcode" :
				Thread.sleep(2000);
				r.firstname("firstname");
				Thread.sleep(2000);
				r.lastname("lastname");
				Thread.sleep(2000);
				r.postalcode("420420");
				break;
			case "Click on Continue button" :
				Thread.sleep(2000);
				r.Continue();
				break;
			case "Click on Finish button" :
				Thread.sleep(2000);
				r.finish();
				TakesScreenshot tss = (TakesScreenshot) cd;
				FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), new File("./SauceDemo.png"));
				break;
			case "Click on Side Menu" :
				Thread.sleep(2000);
				r.sideMenu();
				break;
			case "Click on Logout" :
				Thread.sleep(2000);
				r.logout();
				break;
				
			default:
				System.out.println("Invalid fileformat");
				break;
			}
		}
	}
}
