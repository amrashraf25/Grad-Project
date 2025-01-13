package StepDef;

import Pages.P02_login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class D02_loginStepDef {
    P02_login loginPage;

    @Before
    public void precondition() {
        loginPage = new P02_login(TestBase.driver);
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        loginPage.verifyLoginSuccess("Welcome testuser"); // Replace "testuser" with the actual username
    }
}