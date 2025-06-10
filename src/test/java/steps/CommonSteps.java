package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;

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
}