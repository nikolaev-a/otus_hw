package otus.support;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import otus.factories.WebDriverFactory;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GuiceScoped {

  private EventFiringWebDriver driver = new WebDriverFactory().create();

  public EventFiringWebDriver getDriver(){
    return this.driver;
  }
}


