package cucumberexecuter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/java/featuretestcases",
glue = "cucumbertestcasecode",
plugin = "html:CucumberReport/FlipkartCCReport.html",
dryRun = false,
tags = "@search2 or @multiSearch2"
		)

public class Flipkart_CCBRExecuter extends AbstractTestNGCucumberTests {

}
