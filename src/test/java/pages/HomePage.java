package pages;

import static tools.CommonTools.getByObject;
import static tools.PropertiesLoader.getProperties;

public class HomePage extends BasePage {

    private static final String CIRCLE_NAME_ON_HOME_PAGE_LOCATOR = "xpath=//div[contains(@class, 'header_organization')]";

    public static String getCircleNameOnHomePageLocator() {
        return CIRCLE_NAME_ON_HOME_PAGE_LOCATOR;
    }

    public void assertCircleNameIsDisplayedOnHomePage() {
        wait.forElementToBeDisplayed(10, getByObject(getCircleNameOnHomePageLocator()), "Circle name on Home Page");
        assert driver.findElement(getByObject(getCircleNameOnHomePageLocator())).getText().contains(getProperties("circleName"));
    }
}
