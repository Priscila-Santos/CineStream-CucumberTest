package br.ada.cinestream_test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html"},
        glue = "br.ada.cinestream_test.steps",
        features = "src/test/resources/features"

)
public class CucumberRunner {
}
