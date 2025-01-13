package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

import java.time.Duration;

public class P04_negativeScenarios {
    private WebDriver driver;
    private WebDriverWait wait;

    public P04_negativeScenarios(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By signUpLink = By.id("signin2");
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signUpButton = By.xpath("//button[text()='Sign up']");
    By signUpErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    By loginLink = By.id("login2");
    By loginUsernameField = By.id("loginusername");
    By loginPasswordField = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By loginErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    By addToCartButton = By.xpath("//a[text()='Add to cart']");
    By cartLink = By.id("cartur");
    By cartItems = By.xpath("//tr[@class='success']/td[2]");

    // Actions
    public void navigateToSignUpPage() {
        driver.get("https://www.demoblaze.com/index.html");
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

    public void verifySignUpErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpErrorMessage));
        Assert.assertTrue(message.getText().contains(expectedMessage), "Sign up error message is incorrect.");
    }

    public void navigateToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(loginLink).click();
    }

    public void enterLoginUsername(String username) {
        driver.findElement(loginUsernameField).sendKeys(username);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void verifyLoginErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
        Assert.assertTrue(message.getText().contains(expectedMessage), "Login error message is incorrect.");
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCart() {
        driver.findElement(cartLink).click();
    }

    public void verifyProductInCart(String productName) {
        List<WebElement> items = driver.findElements(cartItems);
        boolean found = false;
        for (WebElement item : items) {
            if (item.getText().equals(productName)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "Product not found in cart.");
    }
}