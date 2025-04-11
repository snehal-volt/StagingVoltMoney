package org.voltMoney.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "", features = {"classpath:features/mandate.feature"},
        glue = {"org/voltMoney/stepDefinitions", "org/voltMoney/hooks"},
        plugin = {"pretty","html:target/cucumberReports.html"}
)
public class MandateTestRunner extends AbstractTestNGCucumberTests {
}
