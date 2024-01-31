package otus.support;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import otus.factories.WebDriverFactory;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GuiceScoped {

  //public EventFiringWebDriver driver = new WebDriverFactory().create();
  private EventFiringWebDriver driver;

  public void setDriver(EventFiringWebDriver driver) {
    this.driver = driver;
  }

  public EventFiringWebDriver getDriver(){
    return this.driver;
  }
}