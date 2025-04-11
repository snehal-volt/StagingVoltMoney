package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

    private By welcomeText = By.xpath("//div[text() = 'Welcome, ']");
    private By continueAppButton = By.xpath("//div[text() = \"Continue application\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyDashboardTitle(){
        String title = driver.getTitle();
        String expectedTitle = "Volt - Unlock cash from your mutual funds saving";
        Assert.assertEquals(title,expectedTitle);
    }

    public void verifyWelcomeText(){
        try{
            WebElement loginCheck = driver.findElement(welcomeText);
            wait.until(ExpectedConditions.visibilityOf(loginCheck));
            System.out.println("Welcome");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickContinueAppButton(){
            WebElement clickContinueAppBtn = driver.findElement(continueAppButton);
            clickContinueAppBtn.click();
            System.out.println("Continue clicked");
    }
}
