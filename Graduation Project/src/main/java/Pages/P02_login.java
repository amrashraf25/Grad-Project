package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P02_login {
    private WebDriver driver;

    public P02_login(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loginLink = By.id("login2");
    By usernameField = By.id("loginusername");
    By passwordField = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By welcomeMessage = By.id("nameofuser");

    // Actions
    public void navigateToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html"); // Navigate to Demoblaze homepage
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void verifyLoginSuccess(String username) {
        String message = driver.findElement(welcomeMessage).getText();
        Assert.assertTrue(message.contains(username), "Login failed.");
    }
}