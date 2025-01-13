package StepDef;

import Pages.P01_register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D01_registerStepDef {
    P01_register registerPage;

    @Given("user navigates to sign up page")
    public void userNavigatesToSignUpPage() {
        registerPage = new P01_register(TestBase.driver);
        registerPage.navigateToSignUpPage();
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
    }

    @When("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        registerPage.clickSignUpButton();
    }

    @Then("user should see a success message")
    public void userShouldSeeASuccessMessage() {
        registerPage.validateSuccessfulRegistration();
    }
}