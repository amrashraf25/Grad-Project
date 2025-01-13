package StepDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;

    @BeforeAll
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set the path to your chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}