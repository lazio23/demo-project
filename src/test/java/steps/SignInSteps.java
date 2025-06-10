package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;

public class RegistrationSteps {

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("a Circle User is on Sign In page")
    public void openSignInPage() {
        homePage.openSignInPage();
    }

    @When("they enter First name {string}")
    public void enterFirstName(String firstName) {
        registrationPage.enterFirstNameOnRegistrationPage(firstName);
    }
}
