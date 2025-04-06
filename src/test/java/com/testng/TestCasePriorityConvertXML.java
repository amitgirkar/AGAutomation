package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCasePriorityConvertXML {
	
	WebDriver w;
	
	@Test(priority = 2, enabled = true)
	public void facebook() throws Exception {
		w.get("https://www.facebook.com/");
	}

	@Test(priority = 1, invocationCount = 3)
	public void amazon() throws Exception {
		w = new ChromeDriver();
		w.get("https://www.amazon.in/");
	}
}
