package factories.implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaConfigure implements IBrowserConfigure{

    private final String browserVersion = System.getProperty("browser.version");

    @Override
    public WebDriver configure() {
        WebDriverManager.operadriver().browserVersion(browserVersion).setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments("--start-maximized");
        operaOptions.addArguments("--homepage=about:blank");

        return new OperaDriver(operaOptions);
    }
}
