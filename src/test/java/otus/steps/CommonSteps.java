package otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import otus.factories.WebDriverFactory;
import otus.pages.MainPage;
import otus.support.GuiceScoped;

public class CommonSteps {

    @Inject
    GuiceScoped guiceScoped;

    @Inject
    WebDriverFactory webDriverFactory;

//    @Inject
//    public MainPage mainPage;

    @Пусть("Открыта главная страница в браузере {string}")
    public void openMainPage(String browserName) {

        guiceScoped.setDriver(webDriverFactory.create(browserName));
        new MainPage(guiceScoped).open()
                .checkPageOpeningMarker();
    }
}