package otus.factories;

import otus.browser.BrowserData;
import otus.exeptions.BrowserNotSupportedException;
import otus.factories.implementation.ChromeConfigure;
import otus.factories.implementation.OperaConfigure;
import otus.factories.implementation.FirefoxConfigure;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class WebDriverFactory implements IFactory<EventFiringWebDriver>{

    private final String browserName = System.getProperty("browser", "chrome");

    @Override
    public EventFiringWebDriver create() {
        switch (BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT))) {
            case CHROME : {
                return new EventFiringWebDriver(new ChromeConfigure().configure());
            }
            case FIREFOX: {
                return new EventFiringWebDriver(new FirefoxConfigure().configure());
            }
            case OPERA: {
                return new EventFiringWebDriver(new OperaConfigure().configure());
            }
            default:{
                throw new BrowserNotSupportedException(browserName);
            }
        }
    }
}