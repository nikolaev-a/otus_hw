package otus.pageobject;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import otus.support.GuiceScoped;
import otus.waiters.Waiter;

public abstract class PageObjectAbs {

    protected WebDriver driver;
    protected GuiceScoped guiceScoped;
    protected Waiter wait;


    @Inject
    public PageObjectAbs(GuiceScoped guiceScoped){
        this.driver = guiceScoped.getDriver();
        this.guiceScoped = guiceScoped;
        this.wait = new Waiter(driver);

        PageFactory.initElements(driver, this);
    }
}