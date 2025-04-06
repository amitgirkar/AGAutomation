package cucumbertestcasecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberTestCaseCode {
	WebDriverData data;	
	WebDriver wd;
	
	public CucumberTestCaseCode(WebDriverData data) {
		this.data = data;
	}

@Given("User has launched the Chrome Browser")
public void user_has_launched_the_chrome_browser() {
    data.wd = new ChromeDriver();
}
@Given("User has opened Front Accounting website")
public void user_has_opened_front_accounting_website() {
    data.wd.get("https://demo.frontaccounting.eu/");
}
@When("User has cleared data and entered {string} in username field")
public void user_has_cleared_data_and_entered_in_username_field(String user) {
    data.wd.findElement(By.name("user_name_entry_field")).clear();
    data.wd.findElement(By.name("user_name_entry_field")).sendKeys(user);
}
@When("User has cleared data and entered {string} in password field")
public void user_has_cleared_data_and_entered_in_password_field(String pass) {
    data.wd.findElement(By.name("password")).clear();
    data.wd.findElement(By.name("password")).sendKeys(pass);
}
@When("User has clicked on Login button")
public void user_has_clicked_on_login_button() {
    data.wd.findElement(By.name("SubmitUser")).click();
}
@Then("Validate login functionality by title of the page")
public void validate_login_functionality_by_title_of_the_page() {
    String expTitle = "Main Menu";
    String actTitle = wd.getTitle();
    Assert.assertEquals(actTitle, expTitle);
}
@Then("User has closed the browser")
public void user_has_closed_the_browser() {
    data.wd.quit();
}

}
