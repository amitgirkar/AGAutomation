package com.datadrivenframework;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingXLSX {

	public static void main(String[] args) throws Exception {
		// Reading XLSX
		
		WebDriver cd = new ChromeDriver();
		cd.get("https://www.google.co.in/");
		
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet3");
		for (int i = 1; i<=6; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell data = row.getCell(0);
			cd.findElement(By.id("APjFqb")).sendKeys(data.toString(),Keys.ENTER);
			Thread.sleep(5000);
			cd.findElement(By.id("APjFqb")).clear();
		}
		cd.quit();

	}

}
