package otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import otus.factories.WebDriverFactory;
import otus.pages.MainPage;
import otus.support.GuiceScoped;

public class CommonSteps {

    @Inject
    GuiceScoped guiceScoped;

    @Inject
    public MainPage mainPage;

    @Inject
    WebDriverFactory webDriverFactory;

    @Пусть("Открыта главная страница в браузере {string}")
    public void openMainPage(String browserName) {
        guiceScoped.setDriver(webDriverFactory.create(browserName));
        mainPage.open()
                .checkPageOpeningMarker();
    }
}