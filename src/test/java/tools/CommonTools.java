package tools;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class CommonTools {

    public static By getByObject(String target) {
        if (target.startsWith("name")) {
            String locatorValue = target.split("=")[1];
            return By.name(locatorValue);
        } else if (target.startsWith("id")) {
            String locatorValue = target.split("=")[1];
            return By.id(locatorValue);
        } else if (target.startsWith("linkText")) {
            String locatorValue = target.split("=")[1];
            return By.linkText(locatorValue);
        } else if (target.startsWith("xpath")) {
            String locatorValue = target.substring(6);
            return By.xpath(locatorValue);
        } else if (target.startsWith("css")) {
            String locatorValue = target.split("=")[1];
            return By.cssSelector(locatorValue);
        }
        return null;
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> scenarioContext = new HashMap<>();

    public static Object getFromContext(String key) {
        return scenarioContext.get(key);
    }

    public static void putInContext(String key, Object value) {
        scenarioContext.put(key, value);
    }
}