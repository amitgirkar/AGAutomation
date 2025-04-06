package com.pageobjectmodel;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMonFlipkart {

	public static void main(String[] args) throws Exception {
		// Page Object Model on Flipkart
		
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.flipkart.com/");
		RepoWOPageFactoryFlipkart f = new RepoWOPageFactoryFlipkart(cd);
		f.Search("iphone");
		Thread.sleep(2000);
		f.product();
		TimeUnit.SECONDS.sleep(2);
		f.windowHandle();
		TimeUnit.SECONDS.sleep(2);
		f.addToCart();
		TimeUnit.SECONDS.sleep(2);
		f.close();
		f.switchParent();
		f.clearProduct();
		f.Search("go pro");
		cd.navigate().refresh();
		f.product();
		f.windowHandle();
		f.addToCart();
		f.close();
	}

}
