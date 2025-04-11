package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MandateSetup {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    private Actions act;

    private By presenceOfMandatePage = By.xpath("//div[text() = \"Setup mandate\"]");
    private By continueButton = By.xpath("//*[@id=\"bt_autoPay_continue\"]/div/div[2]/div");
    private By modeDebitCard = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/label/span");
    private By modeNetbanking = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/label/span");
    private By modeAadhaar = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/label/span");
    private By authoriseCheckbox = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-footer/div/div[1]/div/app-checkbox-component/label/div[2]");
    private By submitButton = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-footer/div/div[3]/div/app-action/div/app-button[2]/button");
    private By cancelButton = By.xpath("//*[@id=\"app-root\"]/app-layout/div/main/app-api-mandate/app-card/div/app-card-footer/div/div[3]/div/app-action/div/app-button[1]/button");
    private By acceptMandateButton = By.xpath("//div[text() = \" Accept \"]");
    private By rejectMandateButton = By.xpath("//div[text() = \" Reject \"]");
    private By mandateFailedCard = By.xpath("");
    private By tryAgainWithSameAccount = By.xpath("//div[text() = \"Try again with same bank account\"]");
    private By tryAgainWithDiffAccount = By.xpath("//div[text() = \"Try with different bank account\"]");

    public MandateSetup(WebDriver driver){ this.driver = driver; act = new Actions(this.driver); }

    public void checkPresenceOfMandatePage(){
        WebElement checkMandateSetupPage = driver.findElement(presenceOfMandatePage);
        wait.until(ExpectedConditions.visibilityOf(checkMandateSetupPage));
        if(checkMandateSetupPage.isDisplayed())
            System.out.println("User is viewing Setup Mandate page");
        else
            System.out.println("This is not Mandate Setup page");
    }

    public void clickContinueButton(){
        WebElement continueBtn = driver.findElement(continueButton);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        act.moveToElement(continueBtn).click().perform();
//        continueBtn.click();
    }

    public void selectDebitMode(){
        WebElement debitRadioButton = driver.findElement(modeDebitCard);
        debitRadioButton.click();
    }

    public void selectNetbankingMode(){
        WebElement netBankingRadioButton = driver.findElement(modeNetbanking);
        netBankingRadioButton.click();
    }

    public void selectAadhaarMode(){
        WebElement aadhaarRadioButton = driver.findElement(modeAadhaar);
        aadhaarRadioButton.click();
    }

    public void checkAuthoriseCheckbox(){
        WebElement clickAuthorise = driver.findElement(authoriseCheckbox);
        clickAuthorise.click();
    }

    public void clickMandateSubmitButton(){
        WebElement clickSubmitButton = driver.findElement(submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(clickSubmitButton));
        if(clickSubmitButton.isEnabled())
            act.moveToElement(clickSubmitButton).click().perform();
//                clickSubmitButton.click();
        else
            System.out.println("Submit button is disabled");
    }

    public void clickMandateCancelButton(){
        WebElement clickCancelButton = driver.findElement(cancelButton);
        wait.until(ExpectedConditions.elementToBeClickable(clickCancelButton));
        act.moveToElement(clickCancelButton).click().perform();
//        clickCancelButton.click();
    }

    public void clickAcceptMandateButton(){
        WebElement clickAccept = driver.findElement(acceptMandateButton);
        wait.until(ExpectedConditions.visibilityOf(clickAccept));
        act.moveToElement(clickAccept).click().perform();
//        clickAccept.click();
    }

    public void clickRejectMandateButton(){
        WebElement clickReject = driver.findElement(rejectMandateButton);
        wait.until(ExpectedConditions.visibilityOf(clickReject));
        act.moveToElement(clickReject).click().perform();
    }

    public void verifyMandateHalfCard() throws InterruptedException {
        Thread.sleep(300);
        WebElement mandateHalfCard = driver.findElement(mandateFailedCard);
        wait.until(ExpectedConditions.visibilityOf(mandateHalfCard));
        if(mandateHalfCard.isDisplayed())
            System.out.println("Mandate request failed card is shown correctly");
        else
            System.out.println("Mandate error half card is not shown");
    }

    public void setTryAgainWithSameAccount(){
        WebElement tryWithSameAccount = driver.findElement(tryAgainWithSameAccount);
        wait.until(ExpectedConditions.visibilityOf(tryWithSameAccount));
        act.moveToElement(tryWithSameAccount).click().perform();
    }

    public void setTryAgainWithDiffAccount(){
        WebElement tryWithDiffAccount = driver.findElement(tryAgainWithDiffAccount);
        wait.until(ExpectedConditions.visibilityOf(tryWithDiffAccount));
        act.moveToElement(tryWithDiffAccount).click().perform();
    }
}

