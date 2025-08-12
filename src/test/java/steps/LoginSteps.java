package steps;

import hooks.Setup;
import hooks.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    private final WebDriver driver = Setup.driver;
    private final Wait wait = new Wait(driver);

    @Given("they open the Flashscore website")
    public void openFlashscoreWebsite() {
        loginPage.openFlashscoreUrl();
    }

    @When("they accept cookies if present")
    public void acceptCookies() {
        loginPage.acceptCookiesIfPresent();
    }

    @And("they click on the login icon")
    public void clickLoginIcon() {
        loginPage.clickLoginIcon();
    }

    @And("they click continue with email")
    public void clickContinueWithEmail() {
        loginPage.clickContinueWithEmail();
    }

    @And("they enter email {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("they enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("they click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("they should see confirmation message")
    public void theyShouldSeeConfirmationMessage() {
        By successMessageLocator = By.xpath("//h2[contains(@class,'lsidDialog__headline') and contains(text(),'logged in successfully')]");

        wait.forElementToBeDisplayed(10, successMessageLocator, "Login success message");

        WebElement element = driver.findElement(successMessageLocator);
        assertTrue("Login success message not displayed", element.isDisplayed());
    }

    @Then("they should see warning messages")
    public void they_should_see_warning_messages() {
        By warningLocator = By.xpath("//*[contains(text(), 'This username or password does not exist.')]");
        wait.forElementToBeDisplayed(10, warningLocator, "Warning message");

        WebElement warning = driver.findElement(warningLocator);
        assertTrue("Warning message is not displayed", warning.isDisplayed());
    }
}