package com.AdvantageDemo.AdvantageDemoAutomatizacion.runner;

import java.io.IOException;

import com.AdvantageDemo.AdvantageDemoAutomatizacion.toolbox.BeforeSuite;
import com.AdvantageDemo.AdvantageDemoAutomatizacion.toolbox.DataToFeature;
import com.AdvantageDemo.AdvantageDemoAutomatizacion.toolbox.RunnerPersonalizado;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

//@RunWith(CucumberWithSerenity.class)
@RunWith(RunnerPersonalizado.class)

@CucumberOptions(features = "src/test/resources/features", tags = {"@CP1_Login_Exitoso"}, glue = "com.AdvantageDemo.AdvantageDemoAutomatizacion.definitions")

public class RunnerFeatures {

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
	DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}

