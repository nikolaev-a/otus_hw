package otus.assertion;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import otus.pageobject.PageObjectAbs;
import otus.support.GuiceScoped;
import otus.waiters.Waiter;

import static org.junit.jupiter.api.Assertions.*;

public class Asserts {

    @Inject
    private Waiter wait;

    public void checkPageOpeningMarker(WebElement marker) {
        wait.waitForElementVisible(marker);
        assertTrue(marker.isDisplayed());
    }
}
