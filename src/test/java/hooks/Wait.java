package hooks;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilCondition(ExpectedCondition<WebElement> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    private void waitUntilConditionBoolean(ExpectedCondition<Boolean> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    private void waitUntilConditionAlert(ExpectedCondition<Alert> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forElementToBeDisplayed(int timeout, By webElement, String webElementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forAnyElementToBeDisplayed(int timeout, String webElementName, By... locators) {
        ExpectedCondition<WebElement> condition = driver -> {
            for (By locator : locators) {
                assert driver != null;
                List<WebElement> elements = driver.findElements(locator);
                for (WebElement element : elements) {
                    if (element.isDisplayed()) {
                        return element;
                    }
                }
            }
            throw new NoSuchElementException("No visible element found among the provided locators");
        };
        String timeoutMessage = webElementName + " elements were not displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToBeNotDisplayed(int timeout, By webElement, String webElementName) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(webElement);
        String timeoutMessage = webElementName + " was still displayed after " + timeout + " seconds.";
        waitUntilConditionBoolean(condition, timeoutMessage, timeout);
    }

    public void forValueToBeUpdated(int timeout, ExpectedCondition<Boolean> condition, String webElementName) {
        String timeoutMessage = webElementName + " was still not updated after " + timeout + " seconds.";
        waitUntilConditionBoolean(condition, timeoutMessage, timeout);
    }

    public void forTextToBeNotEmpty(int timeout, By webElement, String webElementName) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.not(ExpectedConditions.textToBe(webElement, ""));
        String timeoutMessage = webElementName + " was still empty after " + timeout + " seconds.";
        waitUntilConditionBoolean(condition, timeoutMessage, timeout);
    }

    public void forElementToBeEnabled(int timeout, By webElement, String webElementName) {
        forElementToBeDisplayed(timeout, webElement, webElementName);
        ExpectedCondition<Boolean> enabledCondition = driver -> {
            assert driver != null;
            WebElement element = driver.findElement(webElement);
            return element != null && element.isEnabled();
        };
        String timeoutMessage = webElementName + " wasn't enabled after " + timeout + " seconds.";
        waitUntilConditionBoolean(enabledCondition, timeoutMessage, timeout);
    }

    public void forAlertToBeVisible(int timeout, String webElementName) {
        ExpectedCondition<Alert> condition = ExpectedConditions.alertIsPresent();
        String timeoutMessage = webElementName + " wasn't displayed after " + timeout + " seconds.";
        waitUntilConditionAlert(condition, timeoutMessage, timeout);
    }
}