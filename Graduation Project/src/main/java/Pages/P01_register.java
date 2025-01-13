package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P01_register {
    private WebDriver driver;

    public P01_register(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpButton = By.xpath("//button[contains(text(), 'Sign up')]");
    private By successMessage = By.xpath("//div[@class='sweet-alert']/h2");

    public void navigateToSignUpPage() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(signUpLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void validateSuccessfulRegistration() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualMessage = driver.findElement(successMessage).getText();
        Assert.assertEquals(actualMessage, "Sign up successful.");
    }
}