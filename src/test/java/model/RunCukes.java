package model;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
				plugin = {"pretty", "html:target/cucumber"},
				glue="src/test/java/stepdefenition",
				monochrome = true)
public class RunCukes {
	
	public void run() {
		
	}

}
