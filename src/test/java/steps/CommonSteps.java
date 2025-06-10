package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import static org.junit.Assert.assertTrue;
import static tools.CommonTools.getByObject;

public class CommonSteps {

    BasePage basePage = new BasePage();

    @When("they reload the page")
    public void reloadPage() {
        basePage.reloadPage();
    }

    @When("they close the browser window")
    public void closeBrowserWindow() {
        basePage.closeWindowAndOpenNewWindow();
    }

    @When("they go back to the first browser tab")
    public void switchToTheFirstBrowserTab() {
        basePage.switchToTheFirstBrowserTab();
    }

    @And("they close the browser tab")
    public void closeAndOpenNeTab() {
        basePage.closeTabAndOpenNewTab();
    }

    @And("they open another browser tab")
    public void openNewBrowserTab() {
        basePage.openNewTab();
    }

    @Then("they verify that they see element {string}")
    public void theyVerifyThatTheySeeElement(String element) {
        basePage.assertElementIsDisplayed(element);
    }

    @Given("user is on the page {string}")
    public void userIsOnThePage(String url) {
        basePage.openWebPage(url);
    }

    @When("they enter {string} in {string}")
    public void theyEnterIn(String text, String inputElement) {
        basePage.sendKeyToElement(text, inputElement);
    }

    @And("they click {string}")
    public void theyClick(String element) {
        basePage.clickElement(element);
    }

    @And("they clear field {string}")
    public void theyClearField(String element) {
        basePage.clearField(element);
    }

    @Then("assert text {string} presented in {string}")
    public void assertTextPresentedIn(String text, String target) {
        basePage.assertTextPresentedIn(text, target);
    }
}