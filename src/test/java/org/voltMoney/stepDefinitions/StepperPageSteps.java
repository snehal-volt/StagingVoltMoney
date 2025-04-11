package org.voltMoney.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.voltMoney.hooks.BrowserHooks;
import pages.StepperPage;

import java.io.IOException;

public class StepperPageSteps {

    private static final Logger log = LoggerFactory.getLogger(StepperPageSteps.class);
    WebDriver driver = BrowserHooks.getDriver();
    StepperPage stepperPage = new StepperPage(driver);

    public StepperPageSteps() throws IOException{}

    @Given("User is on the stepper page")
    public void userIsOnTheStepperPage() {
        stepperPage.checkStepperPagePresence();
    }

    @And("User clicks on Start button")
    public void userClicksOnStartButton() {
        stepperPage.clickStartButton();
    }
}
