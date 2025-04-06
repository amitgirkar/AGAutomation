package com.datadrivenframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingXLS {

	public static void main(String[] args) throws Exception {
		// Reading XLS
		
		WebDriver cd = new ChromeDriver();
		cd.get("https://www.google.co.in/");
		
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet3");
		for (int i=1; i<=6; i++) {
			HSSFRow row = sheet.getRow(i);
			HSSFCell data = row.getCell(0);
			cd.findElement(By.id("APjFqb")).sendKeys(data.toString(),Keys.ENTER);
			Thread.sleep(5000);
			cd.findElement(By.id("APjFqb")).clear();
		}
		cd.quit();

	}

}
