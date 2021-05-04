package com.spec.test.cucumbertest.cucumberOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.Pickle;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        plugin = {"json",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber-json-report.json"
        },
		features= {"src/test/java/com/spec/test/cucumbertest/features"},
		glue= {"com.spec.test.cucumbertest.stepsdefinition"})
public class TestRunnerNG extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGcucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		testNGcucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "Login scenarios", description = "Runs Login Scenarios", dataProvider = "scenarios")
		    public void LoginTests(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable{
		        testNGcucumberRunner.runScenario(pickleWrapper.getPickle());
		    }
		    @DataProvider
		    public Object[][] scenarios() {
		        return testNGcucumberRunner.provideScenarios();
		    }

		    @AfterClass(alwaysRun = true)
		    public void tearDownClass() {
		        testNGcucumberRunner.finish();
		    }
	
	
}