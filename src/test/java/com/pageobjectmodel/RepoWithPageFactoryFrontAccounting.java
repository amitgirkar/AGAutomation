package com.pageobjectmodel;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RepoWithPageFactoryFrontAccounting {
	WebDriver webdvr;
	String parentWindow;
	
	public RepoWithPageFactoryFrontAccounting(WebDriver wd) {
		PageFactory.initElements(wd, this);
		webdvr = wd;
		}
	
	@FindBy(name = "user_name_entry_field") WebElement username;
	@FindBy(css = "input[name=\"password\"]") WebElement password;
	@FindBy(name = "SubmitUser") WebElement loginBtn;
	@FindBy(linkText = "Sales Quotation Entry") WebElement SQE;
	@FindBy(id = "customer_id") WebElement customer;
	@FindBy(id = "payment") WebElement payment;
	@FindBy(id = "stock_id") WebElement item;
	@FindBy(id = "AddItem") WebElement addItem;
	@FindBy(id = "ProcessOrder") WebElement placeOrder;
	@FindBy(linkText = "View This Quotation") WebElement VTQ;
	@FindBy(linkText = "Close") WebElement VTQClose;
	@FindBy(linkText = "Logout") WebElement logoutBtn;
	
	public void ClearUserName() {
		username.clear();
	}
	public void EnterUserName(String Username) {
		username.sendKeys(Username);
	}
	public void ClearPassword() {
		password.clear();
	}
	public void EnterPassword(String Password) {
		password.sendKeys(Password);
	}
	public void Login() {
		loginBtn.click();
	}
	public void ClickOnSEQ() {
		SQE.click();
	}
	public void Customer(String CustomerVisibleText) {
		Select s = new Select(customer);
		s.selectByVisibleText(CustomerVisibleText);
	}
	public void Payment(String PaymentVisibleText) {
		Select s = new Select(payment);
		s.selectByVisibleText(PaymentVisibleText);
	}
	public void Item(String ItemVisibleText) {
		Select s = new Select(item);
		s.selectByVisibleText(ItemVisibleText);
	}
	public void ClickOnAddItem() {
		addItem.click();
	}
	public void PlaceOrder() {
		placeOrder.click();
	}
	public void VTQ() {
		VTQ.click();
	}
	public void WindowHandle() {
		String parent = webdvr.getWindowHandle();
		parentWindow = parent;
		Set<String> childparent = webdvr.getWindowHandles();
		for (String cp : childparent) {
			if (!cp.equals(parent)) {
				webdvr.switchTo().window(cp);
				Close();
			}
		}
	}
	public void Close() {
		webdvr.close();
	}
	public void SwitchParent() {
		webdvr.switchTo().window(parentWindow);
	}
	public void Logout() {
		logoutBtn.click();
	}
}
