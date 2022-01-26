package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\kajal\\CucumberJave\\src\\test\\resources\\Features", glue= {"StepDefinition.RunnerClass"})//src\\test\\java\\StepDefinition
public class RunnerClass {
	
}
