package com.pageobjectmodel;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RepoWOPageFactoryFlipkart {
	
	private WebDriver b;
	private String mainWindow;
	public RepoWOPageFactoryFlipkart(WebDriver a) {
		b = a;
	}
	
	private By search = By.name("q");
	private By product = By.className("CGtC98");
	private By addToCart = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2\"]");
	private By goToCart = By.className("_9Wy27C");
	private By addToCartOption = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2 JTo6b7\"]");
	
	public void Search(String product) {
		b.findElement(search).sendKeys(product);
		b.findElement(search).submit();
	}
	
	public void product() {
		b.findElement(product).click();		
	}
	
	public void windowHandle() {
		String parent = b.getWindowHandle();
		mainWindow = parent;
		System.out.println(parent);
		Set<String> child = b.getWindowHandles();
		for (String c : child) {
			if (!c.equals(parent)) {
				b.switchTo().window(c);
				System.out.println(c);
			}
		}
	}
	
	public void addToCart() {
		b.navigate().refresh();
		try {
			b.findElement(addToCartOption).click();
		} catch (Exception e) {
			b.findElement(addToCart).click();
			b.findElement(goToCart).click();
		} 
	}
	
	public void close() {
		b.close();
	}
	
	public void switchParent() {
		b.switchTo().window(mainWindow);
	}
	
	public void clearProduct() {
		b.findElement(search).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
	}
}
