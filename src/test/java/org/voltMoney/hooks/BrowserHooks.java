package org.voltMoney.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.ini4j.Ini;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.voltMoney.stepDefinitions.IniFileReader;
//import stepDefinitions.org.voltMoney.IniFileReader;

import java.time.Duration;

public class BrowserHooks {

    static WebDriver driver;
    private static Ini ini;

    @Before
    public void setup() {
        String base_url = IniFileReader.getBaseUrl();
        String browser = IniFileReader.getBrowser();
        if(browser.toLowerCase().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/snehalmahadik/IdeaProjects/StagingVoltMoney/src/test/resources/drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
//            options.addArguments("user-data-dir=/Users/your_username/Library/Application Support/Google/Chrome");
//            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(base_url);
        } else if (browser.toLowerCase().equals("safari")) {
            SafariOptions options = new SafariOptions();
//            options.setUseCleanSession(true);
            driver = new SafariDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(base_url);
        } else if (browser.toLowerCase().equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            System.setProperty("webdriver.gecko.driver", "/Users/snehalmahadik/IdeaProjects/StagingVoltMoney/src/test/resources/drivers/geckodriver");
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(base_url);
        }
        else {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(base_url);
        }
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


public static WebDriver getDriver() {
    return driver;
}

}
