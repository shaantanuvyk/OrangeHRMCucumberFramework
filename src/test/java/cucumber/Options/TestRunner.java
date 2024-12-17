package cucumber.Options;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		//dryRun=true, //Consider if there are 100 feature file and 99th is not implemented it will throw error after 30 mins of execution. SO to avoid this we use dryRun=true and it will make sure all the features are implemented while compiling the code before execution.
		glue={"stepDefinitions"},
		//tags="@SmokeTest",
		//plugin ={"pretty","html:target/cucumber.html","json:target/cucumber.json"},//pretty report gets generated in the local folder (Target location)
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"}, //for extent reports
		monochrome = true
		//publish = true //Publish report on the cucumber.io server, the link gets generated in the console
		)

public class TestRunner extends AbstractTestNGCucumberTests
{

	//@Override
	//@DataProvider(parallel=true)
	/*public Object[][] scenarios()
	{
		return super.scenarios();
	}*/
	
}
