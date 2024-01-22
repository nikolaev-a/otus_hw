package assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseUtilsAbs;
import waiters.Waiter;

import static org.junit.jupiter.api.Assertions.*;

public class Asserts extends BaseUtilsAbs {

    Waiter wait = new Waiter(driver);

    public Asserts(WebDriver driver) {
        super(driver);
    }

    public void checkPageOpeningMarker(WebElement marker) {
        wait.waitForElementVisible(marker);
        assertTrue(marker.isDisplayed());
    }
}
