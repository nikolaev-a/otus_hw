package pages;

import org.openqa.selenium.WebDriver;
import utils.BaseUtilsAbs;

public abstract class BasePageAbs<T> extends BaseUtilsAbs {

    public BasePageAbs(WebDriver driver) {
        super(driver);
    }

    public T open() {

        // реализация
        driver.get("https://google.com/");

        return (T) this;
    }
}
