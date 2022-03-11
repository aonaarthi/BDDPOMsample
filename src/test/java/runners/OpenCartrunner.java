package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		publish = true,
		features="src//test//resources//features//",
		glue={"stepDef"},
		dryRun =false,
		monochrome =true,
		plugin= {"pretty"}
		)
public class OpenCartrunner extends AbstractTestNGCucumberTests {

}
