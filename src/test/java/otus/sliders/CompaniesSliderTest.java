package otus.sliders;

import anotations.Driver;

import anotations.Page;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class CompaniesSliderTest {

    @Driver
    private WebDriver driver;

    @Page
    private MainPage mainPage;

    @Test
    public void testTest() {

        new MainPage(driver).open().checkPage();

    }
}
