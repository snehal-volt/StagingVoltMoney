package org.voltMoney.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.voltMoney.hooks.BrowserHooks;
import pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    //    WebDriver driver = new ChromeDriver();
    private WebDriver driver = BrowserHooks.getDriver();
    Login login;

    //Background
    @Given("User is on Volt Money Login page")
    public void userIsOnVoltMoneyLoginPage() throws IOException {
        login = new Login(driver);
    }

    //Click and enter phone number
    @Given("user clicks and enters valid number {long}")
    public void userClicksAndEntersValidNumber(Long phone) {
        login.enterPhoneNumber(String.valueOf(phone));
//        throw new io.cucumber.java.PendingException();
    }

    //check continue button enabled and click
    @Then("user clicks on Continue button if it is enabled")
    public void userClicksOnContinueButtonIfItIsEnabled() {
        login.enableContinueBtn();
        login.clickSubmitBtn();
    }

    @And("user should be redirected to OTP Page")
    public void userShouldBeRedirectedToOtpPage() {
        login.otpPageNavigation();
    }

    @When("user receives the OTP and enters {int}")
    public void userReceivesTheOtpAndEnters(Integer otp) throws InterruptedException {
        login.enterOtpValues(String.valueOf(otp));
        Thread.sleep(50);
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() throws InterruptedException {
        Thread.sleep(300);
        login.loginSuccess();
    }

    @Then("user should see message indicating error:{string}")
    public void userShouldSeeMessageIndicatingError(String error_message) {
        System.out.println(error_message);
        login.validateErrorMessage(error_message);
    }

    @When("user unchecks T&C and Privacy policy checkbox")
    public void userUnchecksTCAndPrivacyPolicyCheckbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Continue button should be disabled")
    public void continueButtonShouldBeDisabled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
