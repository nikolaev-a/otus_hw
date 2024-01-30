package otus.assertion;

import org.openqa.selenium.WebElement;
import otus.pageobject.PageObjectAbs;
import otus.support.GuiceScoped;

import static org.junit.jupiter.api.Assertions.*;

public class Asserts extends PageObjectAbs{

    public Asserts(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkPageOpeningMarker(WebElement marker) {
        wait.waitForElementVisible(marker);
        assertTrue(marker.isDisplayed());
    }
}
