package StepDef;

import Pages.P04_negativeScenarios;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static StepDef.TestBase.driver;

public class D04_negativeScenariosStepDef {
    P04_negativeScenarios negativeScenariosPage;

    @Before
    public void precondition() {
        negativeScenariosPage = new P04_negativeScenarios(TestBase.driver);
    }

    @Given("user go to sign up page")
    public void userGoToSignUpPage() {
        negativeScenariosPage.navigateToSignUpPage();
    }

    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        negativeScenariosPage.enterUsername(username);
        negativeScenariosPage.enterPassword(password);
    }

    @And("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        negativeScenariosPage.clickSignUpButton();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        negativeScenariosPage.verifySignUpErrorMessage(expectedMessage);
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        negativeScenariosPage.navigateToLoginPage();
    }

    @And("user enter login username {string} and password {string}")
    public void userEnterLoginUsernameAndPassword(String username, String password) {
        negativeScenariosPage.enterLoginUsername(username);
        negativeScenariosPage.enterLoginPassword(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        negativeScenariosPage.clickLoginButton();
    }

    @Then("login error message {string} is displayed")
    public void loginErrorMessageIsDisplayed(String expectedMessage) {
        negativeScenariosPage.verifyLoginErrorMessage(expectedMessage);
    }

    @Given("user go to home page")
    public void userGoToHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    @And("user add product to cart")
    public void userAddProductToCart() {
        negativeScenariosPage.addProductToCart();
    }

    @And("user navigate to cart")
    public void userNavigateToCart() {
        negativeScenariosPage.navigateToCart();
    }

    @Then("product {string} should be in cart")
    public void productShouldBeInCart(String productName) {
        negativeScenariosPage.verifyProductInCart(productName);
    }
}