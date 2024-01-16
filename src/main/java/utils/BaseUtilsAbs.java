package utils;

import org.openqa.selenium.WebDriver;

public abstract class BaseUtilsAbs {

    protected WebDriver driver;

    public BaseUtilsAbs(WebDriver driver) {
        this.driver = driver;
    }
}
