package steps;

import hooks.Wait;
import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.NavigationSectionPage;

import static org.junit.Assert.assertTrue;

public class NavigationSectionSteps {

    private final WebDriver driver = Setup.driver;
    private final Wait wait = new Wait(driver);
    private final NavigationSectionPage NavigationSectionPage = new NavigationSectionPage();

    @Given("Login on the home pages")
    public void loginOnHomePage() {
        LoginPage loginPage = new LoginPage();

        loginPage.openFlashscoreUrl();
        loginPage.acceptCookiesIfPresent();
        loginPage.clickLoginIcon();
        loginPage.clickContinueWithEmail();
        loginPage.enterEmail("will_i_am@ukr.net");
        loginPage.enterPassword("12345678");
        loginPage.clickLoginButton();

        By successMessageLocator = By.xpath("//h2[contains(text(), 'logged in successfully')]");
        wait.forElementToBeDisplayed(10, successMessageLocator, "Login success message");
    }

    @And("they click on the FOOTBALL tab")
    public void clickFootballTab() {
        NavigationSectionPage.clickFootballTab();
    }

    @And("they select Serie A")
    public void selectSerieA() {
        NavigationSectionPage.selectSerieA();
    }

    @And("they select Lazio")
    public void selectLazio() {
        NavigationSectionPage.selectLazio();
    }

    @Then("they see emblema FC Lazio")
    public void seeLazioEmblema() {
        assertTrue("Lazio emblem is not visible", NavigationSectionPage.isLazioEmblemVisible());
    }
}