package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUtilsAbs;

import java.time.Duration;

public class Waiter extends BaseUtilsAbs {

    public Waiter(WebDriver driver) {
        super(driver);
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        try {
            wait.pollingEvery(Duration.ofMillis(100)).until(condition);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean waitForElementLocated(By element) {
        return waitForCondition(ExpectedConditions.presenceOfElementLocated(element));
    }

    public boolean waitForElementToBeClickable(WebElement element) {
        return waitForCondition(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForElementToBeContainsText(WebElement element, String text) {
        return waitForCondition(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public boolean waitForElementVisible(WebElement element) {
        return waitForCondition(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForElementNotVisible(WebElement element) {
        return waitForCondition(ExpectedConditions.invisibilityOf(element));
    }
}
