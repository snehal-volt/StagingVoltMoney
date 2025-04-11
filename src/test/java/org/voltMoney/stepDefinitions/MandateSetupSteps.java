package org.voltMoney.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.voltMoney.hooks.BrowserHooks;
import pages.BankSetup;
import pages.MandateSetup;

public class MandateSetupSteps {

    private static final Logger log = LoggerFactory.getLogger(StepperPageSteps.class);
    WebDriver driver = BrowserHooks.getDriver();
    MandateSetup mandateSetup = new MandateSetup(driver);

    @Given("User is on Setup Mandate page")
    public void userIsOnSetupMandatePage() {
        mandateSetup.checkPresenceOfMandatePage();
    }

    @When("User clicks on Continue button on Mandate page")
    public void userClicksOnContinueButtonOnMandatePage() {
        mandateSetup.clickContinueButton();
    }

    @Then("User selects Verification Mode {string}")
    public void userSelectsVerificationMode(String verifcationMode) {
        if(verifcationMode.toLowerCase().equals("debit"))
            mandateSetup.selectDebitMode();
        else if(verifcationMode.toLowerCase().equals("netbanking"))
            mandateSetup.selectNetbankingMode();
        else
            mandateSetup.selectDebitMode();
    }

    @And("User clicks on authorization checkbox")
    public void userClicksOnAuthorizationCheckbox() {
        mandateSetup.checkAuthoriseCheckbox();
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        mandateSetup.clickMandateSubmitButton();
    }

    @And("User clicks on Reject Mandate")
    public void userClicksOnRejectMandate() {
        mandateSetup.clickRejectMandateButton();
    }

    @Then("User is shown Mandate Request failed half card")
    public void userIsShownMandateRequestFailedHalfCard() throws InterruptedException {
        mandateSetup.verifyMandateHalfCard();
    }

    @And("User clicks on Try again with same bank account button")
    public void userClicksOnTryAgainWithSameBankAccountButton() {
        mandateSetup.setTryAgainWithSameAccount();
    }

    @And("User clicks on Accept button")
    public void userClicksOnAcceptButton() {
        mandateSetup.clickAcceptMandateButton();
    }
}
