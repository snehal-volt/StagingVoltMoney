package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // default timeout 10 seconds
    }

    // Find element with wait
    protected WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("[ERROR] Element not found: " + locator.toString());
            return null;
        }
    }

    // Click an element
    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("[ERROR] Element not clickable: " + locator.toString());
        }
    }

    // Send keys to input field
    public void sendKeys(By locator, String value, boolean clearFirst) {
        WebElement element = findElement(locator);
        if (element != null) {
            if (clearFirst) {
                element.clear();
            }
            element.sendKeys(value);
        }
    }

    // Overloaded sendKeys without clear
    public void sendKeys(By locator, String value) {
        sendKeys(locator, value, true);
    }

    // Check if element is displayed
    public boolean isDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            return element != null && element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
