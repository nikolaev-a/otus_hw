package otus.pages;

import com.google.inject.Inject;
import otus.assertion.Asserts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import otus.support.GuiceScoped;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PythonDeveloper extends BasePageAbs<PythonDeveloper> {

    @Inject
    public PythonDeveloper(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @FindBy(xpath = "//h1[contains(.,'Python Developer')]")
    WebElement headerPage;

    public PythonDeveloper checkHeaderPage() {
        wait.waitForElementVisible(headerPage);
        assertTrue(headerPage.isDisplayed());
        return this;
    }
}
