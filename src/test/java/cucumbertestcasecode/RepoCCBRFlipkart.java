package cucumbertestcasecode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RepoCCBRFlipkart {
	
	WebDriver wd;
	
	public RepoCCBRFlipkart(WebDriver wd2) {
		wd = wd2;
	}
	By search = By.name("q");
	
	public void Website(String url) {
		wd.get(url);
	}
	public void Search(String product) {
		wd.findElement(search).sendKeys(product, Keys.ENTER);
	}
	public void VerifyTitle(String expectedTitle) {
		String actTitle = wd.getTitle();
		boolean ans = actTitle.contains(expectedTitle);
		Assert.assertEquals(ans, true);
	}
	public void CloseBrowser() {
		wd.quit();
	}

}
