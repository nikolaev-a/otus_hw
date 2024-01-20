package pages;

import anotations.URLPrefix;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtilsAbs;

public abstract class BasePageAbs<T> extends BaseUtilsAbs {

    public BasePageAbs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String getBaseUrl() {
        return StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
    }

    private String getUrlPrefix() {
        URLPrefix urlAnnotation = getClass().getAnnotation(URLPrefix.class);
        if (urlAnnotation != null) {
            return urlAnnotation.value();
        }
        return "";
    }

    public T open() {
        driver.get(this.getBaseUrl() + this.getUrlPrefix());
        System.out.println("[ИНФОРМАЦИЯ]: URL страницы на которую совершен переход >>> " + getBaseUrl() + getUrlPrefix());
        return (T) this;
    }
}