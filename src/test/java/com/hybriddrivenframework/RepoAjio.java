package com.hybriddrivenframework;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepoAjio {
	
	WebDriver w;
	String mainpage;
//	[@Attribute="value"]
	public RepoAjio(WebDriver w) {
		PageFactory.initElements(w, this);
		this.w = w;
	}
	@FindBy(css = "input[aria-label=\"Search Ajio\"]") private WebElement search;
	@FindBy(css = "a[class=\"rilrtl-products-list__link desktop\"]") private WebElement product;
	@FindBy(xpath = "//*[@class=\"pdp-addtocart-button\"]/div") private WebElement addToBag;
	@FindBy(css = "a[aria-label=\"cart icon\"]") private WebElement cartIcon;
	@FindBy(xpath = "//*[@class=\"circle size-variant-item size-instock selected\"]") private WebElement size;
//	@FindBy(css = "a[href=\"/\"]") private WebElement hompage;
//	tagname[Attribute = "value"]
	
//	public void homepage() {
//		homepage.click();
//	}
	
	public void search(String searchProduct) {
		search.sendKeys(searchProduct,Keys.ENTER);
	}
	
	public void product() {
		product.click();
	}
	
	public void windowhandle() {
		String parent = w.getWindowHandle();
		mainpage = parent;
		Set<String> child = w.getWindowHandles();
		for (String c : child) {
			if (!c.equals(parent)) {
				w.switchTo().window(c);
			}
		}
	}
	
	public void addToBag() {
		try {
			size.click();
			addToBag.click();
		} catch (Exception e) {
			addToBag.click();
		}
	}
	
	public void cartIcon() {
		WebDriverWait wait = new WebDriverWait(w, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
	}
	
	public void switchToMainPage () {
		w.switchTo().window(mainpage);
	}
	
	public void close() {
		w.close();
	}
}
