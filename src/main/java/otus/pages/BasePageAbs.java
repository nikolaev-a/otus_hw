package otus.pages;

import otus.anotations.URLPrefix;
import com.google.inject.Inject;
import otus.pageobject.PageObjectAbs;
import otus.support.GuiceScoped;


public abstract class BasePageAbs<T> extends PageObjectAbs {

    @Inject
    public BasePageAbs(GuiceScoped scenarioScoped) {
        super(scenarioScoped);
    }

    private String getBaseUrl() {
        return System.getProperty("base.url", "https://otus.ru");
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