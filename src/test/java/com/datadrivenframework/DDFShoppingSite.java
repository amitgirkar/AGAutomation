package com.datadrivenframework;

import java.io.FileInputStream;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DDFShoppingSite {

	public static void main(String[] args) throws Exception {
		// Data Driven Framework on Shopping Website
		
		//WebDriver cd = new ChromeDriver();
		WebDriver ed = new EdgeDriver();
		//cd.get("https://www.myntra.com/");
		ed.get("https://www.myntra.com/");
		
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(3);
		for (int i=1; i<=4; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell product = row.getCell(0);
			//cd.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]")).sendKeys(product.toString(),Keys.ENTER);
			ed.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]")).sendKeys(product.toString(),Keys.ENTER);
			Thread.sleep(2000);
			//cd.findElement(By.cssSelector("h4[class=\"product-product\"]")).click();
			ed.findElement(By.cssSelector("h4[class=\"product-product\"]")).click();
			//String parent = cd.getWindowHandle();
			String parent = ed.getWindowHandle();
			//Set<String> child = cd.getWindowHandles();
			Set<String> child = ed.getWindowHandles();
			for (String c : child) {
				if (!c.equals(parent)) {
					//cd.switchTo().window(c);
					ed.switchTo().window(c);
					Thread.sleep(2000);
					//cd.findElement(By.cssSelector("div.pdp-add-to-bag.pdp-button.pdp-flex.pdp-center")).click();
					ed.findElement(By.cssSelector("div.pdp-add-to-bag.pdp-button.pdp-flex.pdp-center")).click();
					//cd.close();
					ed.close();
					//cd.switchTo().window(parent);
					ed.switchTo().window(parent);
				}
			}
		}
		//cd.quit();
		ed.quit();
	}

}
