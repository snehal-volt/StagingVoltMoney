package org.voltMoney.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.voltMoney.hooks.BrowserHooks;
import pages.HomePage;

import java.io.IOException;

public class HomePageSteps {
    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);
    WebDriver driver = BrowserHooks.getDriver();
    HomePage homePage = new HomePage(driver);

    public HomePageSteps() throws IOException {}

    @Given("User is logged in")
    public void userIsLoggedIn() {
        homePage.verifyDashboardTitle();
    }

    @Given("User should be on the homepage")
    public void userShouldBeOnTheHomepage() {
        homePage.verifyWelcomeText();
    }

    @And("User clicks on Continue Application button")
    public void userClicksOnContinueApplicationButton() {
        homePage.clickContinueAppButton();
    }

    @Then("User should navigate to next page")
    public void userShouldNavigateToNextPage() {
    }
}
