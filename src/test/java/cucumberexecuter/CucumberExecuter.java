package cucumberexecuter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/java/featuretestcases",
glue = "cucumbertestcasecode",
plugin = "html:CucumberReport/cucumberReport.html",
dryRun = false,
tags = "@smoke or @regression"
)

public class CucumberExecuter extends AbstractTestNGCucumberTests {

}
