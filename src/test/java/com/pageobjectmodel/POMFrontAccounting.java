package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMFrontAccounting {

	public static void main(String[] args) throws Exception {
		// 
		WebDriver cd = new ChromeDriver();
		System.out.println("Executor "+cd);
		cd.manage().window().maximize();
		cd.get("https://demo.frontaccounting.eu/");
		RepoWithPageFactoryFrontAccounting f = new RepoWithPageFactoryFrontAccounting(cd);
		f.ClearUserName();
		f.EnterUserName("demouser");
		f.ClearPassword();
		f.EnterPassword("password");
		Thread.sleep(2000);
		f.Login();
		f.ClickOnSEQ();
		f.Customer("WWW");
		f.Payment("Payment due within 10 days");
		cd.navigate().refresh();
		f.Item("Milk");
		f.ClickOnAddItem();
		f.PlaceOrder();
		Thread.sleep(2000);
		f.VTQ();
		Thread.sleep(2000);
		f.WindowHandle();
		f.SwitchParent();
		f.Logout();
		f.Close();
	}
}
