package com.keyworddrivenframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoSauceDemo {
	public RepoSauceDemo(WebDriver wd) {
		PageFactory.initElements(wd, this);	
	}
	@FindBy(id = "user-name") private WebElement username;
	@FindBy(name = "password") private WebElement password;
	@FindBy(css = "input[value=\"Login\"]") private WebElement login;
	@FindBy(id = "add-to-cart-sauce-labs-backpack") private WebElement addToCart;
	@FindBy(css = "a[data-test=\"shopping-cart-link\"]") private WebElement goToCart;
	@FindBy(name = "checkout") private WebElement checkout;
	@FindBy(css = "input[placeholder=\"First Name\"]") private WebElement firstname;
	@FindBy(id = "last-name") private WebElement lastname;
	@FindBy(id = "postal-code") private WebElement postalcode;
	@FindBy(id = "continue") private WebElement Continue;
	@FindBy(id = "finish") private WebElement finish;
	@FindBy(id = "react-burger-menu-btn") private WebElement sideMenu;
	@FindBy(linkText = "Logout") private WebElement logout;
	
	public void username(String user) {
		username.sendKeys(user);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void login() {
		login.click();
	}
	public void addToCart() {
		addToCart.click();
	}
	public void goToCart() {
		goToCart.click();
	}
	public void checkout() {
		checkout.click();
	}
	public void firstname(String fname) {
		firstname.sendKeys(fname);
	}
	public void lastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void postalcode(String pcode) {
		postalcode.sendKeys(pcode);
	}
	public void Continue() {
		Continue.click();
	}
	public void finish() {
		finish.click();
	}
	public void sideMenu() {
		sideMenu.click();
	}
	public void logout() {
		logout.click();
	}
}
