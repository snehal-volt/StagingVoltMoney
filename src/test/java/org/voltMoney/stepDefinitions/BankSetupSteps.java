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

public class BankSetupSteps {
    private static final Logger log = LoggerFactory.getLogger(StepperPageSteps.class);
    WebDriver driver = BrowserHooks.getDriver();
    BankSetup bankSetup = new BankSetup(driver);

    @Given("User is on Link Bank account page")
    public void userIsOnLinkBankAccountPage(){
        bankSetup.presenceOfLinkBankAccountPage();
    }

    @And("User clicks on Add Bank account")
    public void userClicksOnAddBankAccount() {
        bankSetup.clickAddBankAccount();
    }

    @Then("User is shown Select your bank page")
    public void userIsShownSelectYourBankPage() {

    }

    @When("User clicks on popular bank {string}")
    public void userClicksOnPopularBank(String bankName) {
        if(bankName.toLowerCase().equals("hdfc"))
            bankSetup.setSelectPopularHdfcBank();
        else if(bankName.toLowerCase().equals("icici"))
            bankSetup.setSelectPopularIciciBank();
        else
            bankSetup.setSelectPopularHdfcBank();
    }


    @Then("User is shown Enter account details page")
    public void userIsShownEnterAccountDetailsPage() {
    }

    @Then("User clicks and enters bank account number {string}")
    public void userClicksAndEntersBankAccountNumber(String bankAccountNumber) {
        bankSetup.setEnterBankAccountNumber(bankAccountNumber);
    }

    @Then("User clicks and enters ifsc code {string}")
    public void userClicksAndEntersIfscCode(String ifscCode) throws InterruptedException {
        bankSetup.setEnterIfscCode(ifscCode);
    }

    @And("User selects ifsc code")
    public void userSelectsIfscCode() throws InterruptedException {
        bankSetup.selectIfscCode();
    }

    @And("User clicks on Verify bank account button")
    public void userClicksOnVerifyBankAccountButton() throws InterruptedException {
        bankSetup.clickVerifyBankAccountButton();
    }
}
