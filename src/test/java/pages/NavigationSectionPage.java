package pages;

import hooks.Setup;
import hooks.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static tools.CommonTools.getByObject;

public class NavigationSectionPage {

    private final WebDriver driver;
    private final Wait wait;

    public NavigationSectionPage() {
        this.driver = Setup.driver;
        this.wait = new Wait(driver);
    }

    private final String FOOTBALL_TAB_LOCATOR = "xpath=//a[@data-sport-id='1']//div[contains(text(), 'Football')]";
    private final String SERIE_A_LINK_LOCATOR = "xpath=//a[contains(@href, '/football/italy/serie-a') and .//span[text()='Serie A']]";
    private final String LAZIO_LINK_LOCATOR = "xpath=//a[contains(@href, '/team/lazio') and text()='Lazio']";
    private final String LAZIO_EMBLEM_LOCATOR = "xpath=//img[@alt='Lazio']";

    public void clickFootballTab() {
        By overlay = By.cssSelector("div[data-testid='wcl-dialog-overlay']");
        wait.waitForOverlayToDisappear(overlay, 10);

        By footballTab = getByObject(FOOTBALL_TAB_LOCATOR);
        wait.forElementToBeDisplayed(10, footballTab, "Football tab");
        driver.findElement(footballTab).click();
    }

    public void selectSerieA() {
        By serieA = getByObject(SERIE_A_LINK_LOCATOR);
        wait.forElementToBeDisplayed(10, serieA, "Serie A link");
        driver.findElement(serieA).click();
    }

    public void selectLazio() {
        By lazio = getByObject(LAZIO_LINK_LOCATOR);
        wait.forElementToBeDisplayed(10, lazio, "Lazio link");
        driver.findElement(lazio).click();
    }

    public boolean isLazioEmblemVisible() {
        By emblem = getByObject(LAZIO_EMBLEM_LOCATOR);
        wait.forElementToBeDisplayed(10, emblem, "Lazio emblem");
        WebElement lazioLogo = driver.findElement(emblem);
        return lazioLogo.isDisplayed();
    }
}