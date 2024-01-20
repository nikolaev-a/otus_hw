package otus.sliders;

import anotations.Page;

import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class CompaniesSliderTest {

//    @Driver
//    WebDriver driver;

    @Page
    MainPage mainPage;

    @Test
    public void testTest() throws InterruptedException {

        mainPage.open()
                .checkPageOpeningMarker()
                .highlightElement()
                .removeHighlightElement()
                .filterByCourseName("Специализация сетевой инженер");

    }
}