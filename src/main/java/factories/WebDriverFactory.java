package factories;

import exeptions.BrowserNotSupportedException;
import factories.implementation.ChromeConfigure;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory implements IFactory<EventFiringWebDriver>{

    private final String browserName = System.getProperty("browser");

    @Override
    public EventFiringWebDriver create() {
        switch (browserName) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromeConfigure().configure());
            }
            default:{
                throw new BrowserNotSupportedException(browserName);
            }
        }
    }
}
