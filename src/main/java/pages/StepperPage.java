package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepperPage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

    private By startButton = By.xpath("//div[text() = 'Start']");
    private By presenceOfKycText = By.xpath("//div[text() = 'KYC Verification']");
    private By presenceOfSetupBankText = By.xpath("//div[text() = 'Setup bank and autopay']");
//    private By continueAppButton = By.xpath("//div[text() = \"Continue application\"]");

    public StepperPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkStepperPagePresence(){
        WebElement KycVerification = driver.findElement(presenceOfKycText);
        WebElement SetupBankMandate = driver.findElement(presenceOfSetupBankText);
        if(KycVerification.isDisplayed() && SetupBankMandate.isDisplayed()){
            System.out.println("Stepper Page");
        }
        else{
            System.out.println("User is not on Stepper page");
        }
    }

    public void clickStartButton(){
        WebElement clickStartButton = driver.findElement(startButton);
        wait.until(ExpectedConditions.visibilityOf(clickStartButton));
        clickStartButton.click();
    }
}
