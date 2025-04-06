package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws Exception {
		// 
		
		WebDriver cd = new ChromeDriver();
		cd.get("https://cloudconvert.com/");
		Thread.sleep(2000);
		cd.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div/input")).sendKeys("D:\\SauceDemo.png");
	}
}
