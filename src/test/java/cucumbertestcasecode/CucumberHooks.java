package cucumbertestcasecode;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	WebDriverData data;
	
	public CucumberHooks(WebDriverData d) {
		data = d;
	}
	@Before
	public void launchBrowser() {
		data.wd = new ChromeDriver();
	}
	@After
	public void closeBroser() {
		data.wd.quit();
	}

}
