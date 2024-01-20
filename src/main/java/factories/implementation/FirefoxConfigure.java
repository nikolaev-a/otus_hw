package factories.implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxConfigure implements IBrowserConfigure {

    private final String browserVersion = System.getProperty("browser.version");

    @Override
    public WebDriver configure() {
        WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--homepage=about:blank");

        return new FirefoxDriver(firefoxOptions);
    }
}
