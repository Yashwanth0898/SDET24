package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={".\\src\\test\\java\\com\\org\\features"},
glue= {"stepDefinitions","hook"},
dryRun =false,//check the step defination whether all the scenarios steps implemented
plugin= {"pretty","html:cucumberreport.html",
		"json:cucumberreportjson.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},//to print the scenario steps in console
monochrome=true
,tags="@smoketest")//to remove special characters in console output
//tags="@smoketest or @regressiontest")//if we want to execute either smoke or regression

public class Runner extends AbstractTestNGCucumberTests {
	
}
