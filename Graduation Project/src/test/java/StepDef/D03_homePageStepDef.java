package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class D03_homePageStepDef {
    P03_homePage homePage;

    @Before
    public void precondition() {
        homePage = new P03_homePage(TestBase.driver);
    }

    @Given("user go to home page")
    public void userGoToHomePage() {
        homePage.navigateToHomePage();
    }

    @And("user click on laptops category")
    public void userClickOnLaptopsCategory() {
        homePage.clickLaptopsCategory();
    }

    @And("user select product {string}")
    public void userSelectProduct(String productName) {
        homePage.selectProduct(productName);
    }

    @And("user add product to cart")
    public void userAddProductToCart() {
        homePage.addProductToCart();
    }

    @And("user navigate to cart")
    public void userNavigateToCart() {
        homePage.navigateToCart();
    }

    @Then("product {string} should be in cart")
    public void productShouldBeInCart(String productName) {
        homePage.verifyProductInCart(productName);
    }

    @And("user verify product {string} price is {string}")
    public void userVerifyProductPriceIs(String productName, String expectedPrice) {
        homePage.verifyProductPriceInCart(productName, expectedPrice);
    }

    @And("user verify total amount is {string}")
    public void userVerifyTotalAmountIs(String totalAmount) {
        homePage.verifyTotalAmount(totalAmount);
    }

    @And("user click on place order button")
    public void userClickOnPlaceOrderButton() {
        homePage.clickPlaceOrderButton();
    }

    @And("user fill checkout form with name {string}, country {string}, city {string}, credit card {string}, month {string}, and year {string}")
    public void userFillCheckoutForm(String name, String country, String city, String creditCard, String month, String year) {
        homePage.fillCheckoutForm(name, country, city, creditCard, month, year);
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
        homePage.clickPurchaseButton();
    }

    @Then("purchase is successful")
    public void purchaseIsSuccessful() {
        homePage.verifyPurchaseSuccess();
    }
}