package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;


public class SignInSteps {

    LoginPage signInPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Given("a Circle User is on Sign In page")
    public void openSignInPage() {
        signInPage.openSignInPage();
    }

    @When("they enter {string} address")
    public void enterInvalidEmail(String email) {
        signInPage.enterEmailOnSignInPage(email);
    }

    @And("they enter {string}")
    public void theyEnterPassword(String password) {
        signInPage.enterPasswordOnSignInPage(password);
    }

    @And("click Sign In button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("they see a warning message")
    public void theySeeWarningMessage() {
        signInPage.assertNoUserWarningMessage();
    }
}
