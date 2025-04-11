package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class BankSetup{

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    private Actions act;

    private By linkBankAccountText = By.xpath("//div[text() = \"Link bank account\"]");
    private By addBankAccount = By.xpath("//div[text() = \" Add Bank account\"]");
    private By selectPopularHdfcBank = By.xpath("//*[@id=\"txt_bankVerification_selectBank_HDFC Bank\"]/div/div/div[3]");
    private By selectPopularIciciBank = By.xpath("//*[@id=\"txt_bankVerification_selectBank_ICICI Bank\"]/div/div/div[3]");
    private By enterBankName = By.xpath("//*[@id=\"tf_bankVerification_searchBank\"]");
    private By selectSearchedBankHdfc = By.xpath("//div[text() = \"HDFC Bank \"]");
    private By enterBankAccountNumber = By.xpath("//*[@id=\"tf_addBankPage_enterAccountNumber\"]");
    private By enterIfscCode = By.xpath("//input[@id = \"tf_addBankPage_searchBranch\"]");
    private By clickIfscCode = By.xpath("//*[@id=\"tf_searchBranch_searchBranch\"]");
    private By selectIfscCode = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[6]/div/div/div/div[2]/div/div/div/div/div/div/div[6]/div/div/div");
    private By verifyBankAccountButton = By.xpath("//div[text() = \"Verify bank account\"]");

    public BankSetup(WebDriver driver){ this.driver = driver; act = new Actions(this.driver); }

    public void presenceOfLinkBankAccountPage(){
        WebElement getLinkBankAccountPage = driver.findElement(linkBankAccountText);
        wait.until(ExpectedConditions.visibilityOf(getLinkBankAccountPage));
        if(getLinkBankAccountPage.isDisplayed())
            System.out.println("User is viewing Link Bank Account page");
        else
            System.out.println("This is not Link Bank Account page");
    }

    public void clickAddBankAccount(){
        WebElement clickAddBank = driver.findElement(addBankAccount);
        clickAddBank.click();
    }

    public void setSelectPopularHdfcBank(){
        WebElement selectHdfcBank = driver.findElement(selectPopularHdfcBank);
        selectHdfcBank.click();
    }

    public void setSelectPopularIciciBank(){
        WebElement selectIciciBank = driver.findElement(selectPopularIciciBank);
        selectIciciBank.click();
    }

    public void setEnterBankName(String bankName){
        WebElement enterBank = driver.findElement(enterBankName);
        enterBank.clear();
        enterBank.sendKeys(bankName);
    }

    public void setSelectSearchedBankHdfc(){
        WebElement searchedHdfcBank = driver.findElement(selectSearchedBankHdfc);
        searchedHdfcBank.click();
    }

    public void setEnterBankAccountNumber(String bankAccountNumber) {
        WebElement enterBankAccount = driver.findElement(enterBankAccountNumber);
        wait.until(ExpectedConditions.visibilityOf(enterBankAccount));
        enterBankAccount.click();
        enterBankAccount.clear();
        enterBankAccount.sendKeys(bankAccountNumber);
//        wait(10);
    }

    public void setEnterIfscCode(String ifscCode) throws InterruptedException {
        WebElement enterIfsc = driver.findElement(enterIfscCode);
        enterIfsc.click();
        WebElement clickIfsc = driver.findElement(clickIfscCode);
        wait.until(ExpectedConditions.elementToBeClickable(clickIfsc));
//        Thread.sleep(20);
        clickIfsc.click();
        clickIfsc.sendKeys(ifscCode);
        System.out.println("IFSC Entered");
    }

    public void selectIfscCode() throws InterruptedException {
        WebElement selectIfsc = driver.findElement(selectIfscCode);
        wait.until(ExpectedConditions.visibilityOf(selectIfsc));
        selectIfsc.click();
    }

    public void clickVerifyBankAccountButton() throws InterruptedException {
        Thread.sleep(30);
        WebElement clickVerifyButton = driver.findElement(verifyBankAccountButton);
        if(clickVerifyButton.isEnabled()){
            wait.until(ExpectedConditions.elementToBeClickable(clickVerifyButton));
            act.moveToElement(clickVerifyButton).click().perform();
        }
    }


}
