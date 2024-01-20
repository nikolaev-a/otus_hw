package factories;

import exeptions.BrowserNotSupportedException;
import factories.implementation.ChromeConfigure;
import factories.implementation.OperaConfigure;
import factories.implementation.FirefoxConfigure;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory implements IFactory<EventFiringWebDriver>{

    private final String browserName = System.getProperty("browser");

    @Override
    public EventFiringWebDriver create() {
        switch (browserName) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromeConfigure().configure());
            }
            case "firefox": {
                return new EventFiringWebDriver(new FirefoxConfigure().configure());
            }
            case "opera": {
                return new EventFiringWebDriver(new OperaConfigure().configure());
            }
            default:{
                throw new BrowserNotSupportedException(browserName);
            }
        }
    }
}