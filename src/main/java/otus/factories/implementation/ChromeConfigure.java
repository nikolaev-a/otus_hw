package otus.factories.implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfigure implements IBrowserConfigure{

    private final String browserVersion = System.getProperty("browser.version");

    @Override
    public WebDriver configure() {
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--homepage=about:blank");

        return new ChromeDriver(chromeOptions);
    }
}
