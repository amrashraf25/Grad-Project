package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P03_homePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public P03_homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By laptopsCategory = By.xpath("//a[contains(text(),'Laptops')]");
    By product1Link = By.xpath("//a[contains(text(),'Samsung galaxy s6')]");
    By product2Link = By.xpath("//a[contains(text(),'Nexus 6')]");
    By addToCartButton = By.xpath("//a[text()='Add to cart']");
    By cartLink = By.id("cartur");
    By cartItems = By.xpath("//tr[@class='success']/td[2]");
    By cartPrices = By.xpath("//tr[@class='success']/td[3]");
    By totalAmount = By.id("totalp");
    By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By creditCardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    By successMessage = By.xpath("//div[@class='sweet-alert']/h2");

    // Actions
    public void navigateToHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }

    public void selectProduct(String productName) {
        if (productName.equals("Samsung galaxy s6")) {
            driver.findElement(product1Link).click();
        } else if (productName.equals("Nexus 6")) {
            driver.findElement(product2Link).click();
        }
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

    public void verifyProductPriceInCart(String productName, String expectedPrice) {
        List<WebElement> items = driver.findElements(cartItems);
        List<WebElement> prices = driver.findElements(cartPrices);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals(productName)) {
                String actualPrice = prices.get(i).getText();
                Assert.assertEquals(actualPrice, expectedPrice, "Price is incorrect for product: " + productName);
                break;
            }
        }
    }

    public void verifyTotalAmount(String expectedTotal) {
        String total = driver.findElement(totalAmount).getText();
        Assert.assertEquals(total, expectedTotal, "Total amount is incorrect.");
    }

    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillCheckoutForm(String name, String country, String city, String creditCard, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(creditCardField).sendKeys(creditCard);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void verifyPurchaseSuccess() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertTrue(message.getText().contains("Thank you for your purchase!"), "Purchase success message not displayed.");
    }
}