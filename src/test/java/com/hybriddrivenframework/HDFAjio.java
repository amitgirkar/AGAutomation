package com.hybriddrivenframework;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFAjio {

	public static void main(String[] args) throws Exception {
		// Hybrid Driven Framework on Ajio
		
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		RepoAjio a = new RepoAjio(cd);
		cd.get("https://www.ajio.com/");
		FileInputStream fis = new FileInputStream("D:\\Amit G\\Automation\\DataDrivenFramework.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Ajio");
		for (int i=1; i<=3; i++) {
			XSSFRow testdata = sheet.getRow(i);
			XSSFCell search = testdata.getCell(0);
			for (int j=1; j<=4; j++) {
				XSSFRow teststep = sheet.getRow(j);
				XSSFCell step = teststep.getCell(1);
				
				switch (step.toString()) {
				case "Search the product":
//					a.homepage();
					a.search(search.toString());					
					break;
					
				case "Click on product":
					a.product();
					a.windowhandle();
					break;
					
				case "Click on Add to Bag button":
					a.addToBag();
					break;
					
				case "Click on Bag icon":
					Thread.sleep(3000);
					a.cartIcon();
					Thread.sleep(3000);
					a.close();
					a.switchToMainPage();

				default:
					break;
				}
			}
		}
		a.cartIcon();
	}

}
