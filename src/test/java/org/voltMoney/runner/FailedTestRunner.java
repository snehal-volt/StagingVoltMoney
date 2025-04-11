package org.voltMoney.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "", features = {"@target/rerun.txt"},
        glue = {"org/voltMoney"},
        plugin = {"pretty","html:target/htmlreport.html"}
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

}
