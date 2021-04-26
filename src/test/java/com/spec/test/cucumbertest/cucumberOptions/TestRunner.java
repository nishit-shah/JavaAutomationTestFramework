package com.spec.test.cucumbertest.cucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import com.spec.framework.base.DriverContext;
import com.spec.framework.config.ConfigReader;
import com.spec.framework.config.Settings;
import com.spec.framework.utilities.ExcelUtil;
import com.spec.framework.utilities.LogUtil;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/com/spec/test/cucumbertest/features"},
		glue= {"com.spec.test.cucumbertest.stepsdefinition"})
public class TestRunner {


}