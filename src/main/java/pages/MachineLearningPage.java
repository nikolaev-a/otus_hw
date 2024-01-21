package pages;

import anotations.URLPrefix;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

@URLPrefix("/lessons/ml-specialization/")
public class MachineLearningPage extends BasePageAbs<MachineLearningPage> {

    public MachineLearningPage(WebDriver driver) {
        super(driver);
    }
}
