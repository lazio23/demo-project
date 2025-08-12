package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static tools.CommonTools.getByObject;

public class LoginPage extends BasePage {


    private static final String EMAIL_INPUT_FIELD_LOCATOR = "id=email";
    private static final String LOGIN_ICON_ON_LOGIN_PAGE_LOCATOR = "cssSelector=div#user-menu.header__button.header__button--user";
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "xpath=//span[text()='Continue with email']/ancestor::button";
    private static final String LOGIN_BUTTON_ON_LOGIN_PAGE_LOCATOR = "xpath=//span[contains(@class, 'wcl-overline') and contains(text(), 'Log In')]";
    private static final String PASSWORD_INPUT_FIELD_LOCATOR = "xpath=//input[@type='password']";


    public static String getEmailInputFieldLocator() {
        return EMAIL_INPUT_FIELD_LOCATOR;
    }

    public static String getPasswordInputFieldLocator() {
        return PASSWORD_INPUT_FIELD_LOCATOR;
    }

    public static String getLoginIconOnLoginPageLocator() {
        return LOGIN_ICON_ON_LOGIN_PAGE_LOCATOR;
    }

    public static String getContinueWithEmailButtonLocator() {
        return CONTINUE_WITH_EMAIL_BUTTON_LOCATOR;
    }

    public static String getLoginButtonOnLoginPageLocator() {
        return LOGIN_BUTTON_ON_LOGIN_PAGE_LOCATOR;
    }


    public void enterEmail(String email) {
        wait.forElementToBeDisplayed(10, getByObject(getEmailInputFieldLocator()), "Email input field");
        driver.findElement(getByObject(getEmailInputFieldLocator())).sendKeys(email);
    }

    public void enterPassword(String password) {
        By passwordField = getByObject(getPasswordInputFieldLocator());
        wait.forElementToBeDisplayed(10, passwordField, "Password input field");
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginIcon() {
        wait.forElementToBeDisplayed(10, getByObject(getLoginIconOnLoginPageLocator()), "Login icon");
        driver.findElement(getByObject(getLoginIconOnLoginPageLocator())).click();
    }

    public void clickContinueWithEmail() {
        wait.forElementToBeDisplayed(10, getByObject(getContinueWithEmailButtonLocator()), "Continue with email");
        driver.findElement(getByObject(getContinueWithEmailButtonLocator())).click();
    }

    public void clickLoginButton() {
        wait.forElementToBeDisplayed(10, getByObject(getLoginButtonOnLoginPageLocator()), "Login button");
        driver.findElement(getByObject(getLoginButtonOnLoginPageLocator())).click();
    }

    public void openFlashscoreUrl() {
        driver.get("https://www.flashscore.com/");
    }

    public void acceptCookiesIfPresent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")))
                    .click();
        } catch (Exception ignored) {
        }
    }
}