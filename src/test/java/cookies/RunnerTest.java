package cookies;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import java.io.File;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "json:target/json/output.json" }, features = { "src/test/resources/Feature"}, glue = {
		"step_definitions" } ,tags= {"@tag4" }, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class RunnerTest {
	@AfterClass
	public static void teardown() {

		Reporter.loadXMLConfig(new File("target/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}