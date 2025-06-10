package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assume;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browserType = prop.getProperty("browser");

        switch (browserType.toLowerCase()) {
            case "chrome":
                setupChrome();
                break;
            case "firefox":
                setupFirefox();
                break;
            case "safari":
                setupSafari();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }

    @Before("@Skip")
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipping scenario: " + scenario.getName());
        Assume.assumeTrue("Scenario marked with @Skip - Skipping!", false);
    }

    private void setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        //options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-software-rasterizer");
        driver = new ChromeDriver(options);
    }

    private void setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new FirefoxDriver(options);
    }

    private void setupSafari() {
        if (!WebDriverManager.getInstance(SafariDriver.class).getBrowserPath().isPresent()) {
            throw new IllegalStateException("SafariDriver is not available. Make sure to install it or choose another browser.");
        }

        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().setSize(new Dimension(1600, 1000));
    }
}