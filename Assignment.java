package RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false,
features = {"src/test/java/Features/Duplicate.feature"},
glue = {"Steps"},
monochrome = true
)

public class Assignment extends AbstractTestNGCucumberTests {

}
