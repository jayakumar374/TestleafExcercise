package RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(dryRun = false,
features = {"src/test/java/Features"},
glue = {"Steps","hooks"},
monochrome = true,
tags = "@delete"
)

public class Assignment_Servicenow extends AbstractTestNGCucumberTests {

}
