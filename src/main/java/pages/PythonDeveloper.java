package pages;

import assertion.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PythonDeveloper extends BasePageAbs<PythonDeveloper> {

    Asserts asserts = new Asserts(driver);

    public PythonDeveloper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(.,'Python Developer')]")
    WebElement headerPage;

    public PythonDeveloper checkHeaderPage() {
        asserts.checkPageOpeningMarker(headerPage);
        return this;
    }
}
