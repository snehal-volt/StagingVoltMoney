package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;


public class Login {

    protected WebDriver driver;
    private Actions act;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

 //Login constructor
    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        act = new Actions(this.driver);
//        this.jsonReader = new JsonReader(locators);
    }

    //Locators
    private By mobilenumber = By.xpath("//*[@id=\"Mobile number\"]");
    private By phoneField = By.xpath("//input[@id=\"Mobile number\"]");
    private By continueBtn = By.xpath("//*[text()=\"Continue\"]");
    private By otpPage = By.xpath("//*[text()=\"Enter OTP\"]");
    private By errorMessage = By.xpath("//div[contains(text(),'123456 is not a valid OTP. You have 4 attempts left.')]");
    private By welcomeText = By.xpath("//div[contains(text(),'Welcome')]");


    //click and sendKeys on phone number field method
    public void enterPhoneNumber(String phoneNumber) {
        WebElement mobNum = driver.findElement(mobilenumber);
        mobNum.click();
        WebElement phoneInput = driver.findElement(phoneField);
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.click();
//        act.moveToElement(phoneInput).click().perform();
//        act.sendKeys(phoneInput, phoneNumber).perform();
        phoneInput.sendKeys(phoneNumber);
    }

    //Check continue button is enabled
    public void enableContinueBtn(){
        WebElement continueButton = driver.findElement(continueBtn);
        boolean enabled = continueButton.isEnabled();
        Assert.assertTrue(enabled);
    }

    //click Continue button to submit phone number method
    public void clickSubmitBtn() {
        WebElement continueButton = driver.findElement(continueBtn);
        continueButton.click();
    }

    //navigate to OTP page mehtod
    public void otpPageNavigation() {
        try {
            WebElement otpPageText = driver.findElement(otpPage);
            String actualOtpText = otpPageText.getText();
            String expectedOtpText = "Enter OTP";
            Assert.assertEquals(expectedOtpText, actualOtpText);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //enter otp field values
    public void enterOtpValues(String otp){
        try{
            for (int i = 0; i < otp.length(); i++) {
                // Find the OTP input field using a dynamic XPath or CSS selector based on index or unique attributes
                // Assuming there are 6 fields for OTP and we can locate them via their order in the DOM
                WebElement otpField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div[4]/input[" + (i + 1) + "]"));
                act.click(otpField);
                otpField.clear();
                otpField.sendKeys(String.valueOf(otp.charAt(i)));
            }

//          Old Architecture OTP field code
//            List<WebElement> otpFields = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div[4]/input[1]"));
//            System.out.println(otpFields.size());
//            if (otpFields.size() == otp.length()) {
//                for (int i = 0; i < otp.length(); i++) {
//                    // Send each OTP digit to the corresponding input field
//                    wait.until(ExpectedConditions.elementToBeClickable(otpFields.get(i)));
//                    act.click(otpFields.get(i));
//                    char curr = otp.charAt(i);
//                    act.sendKeys(otpFields.get(i), String.valueOf(curr)).perform();
//
////                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//                }
//            } else {
//                System.out.println("Mismatch between OTP fields and OTP digits.");
//            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Login success
    public void loginSuccess(){
        try{
            WebElement loginCheck = driver.findElement(welcomeText);
            wait.until(ExpectedConditions.visibilityOf(loginCheck));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Validate error message
    public void validateErrorMessage(String expectedMsg){
        WebElement errorMsg = driver.findElement(errorMessage);
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        String actualMsg = errorMsg.getText();
//        String attribute = errorMsg.getAttribute(expectedMessage);
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    public void successfulLogin(String phoneNumber, String otp){
        WebElement phoneInput = driver.findElement(phoneField);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);
        WebElement continueButton = driver.findElement(continueBtn);
        continueButton.click();
        for (int i = 0; i < otp.length(); i++) {
            WebElement otpField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div[4]/input[" + (i + 1) + "]"));
            act.click(otpField);
            otpField.clear();
            otpField.sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

}
