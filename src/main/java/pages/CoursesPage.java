package pages;

import anotations.URLPrefix;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

@URLPrefix("/catalog/courses")
public class CoursesPage extends BasePageAbs<CoursesPage> {

    Waiter waiter = new Waiter(driver);

    public CoursesPage(WebDriver driver) {
        super(driver);
    }
}
