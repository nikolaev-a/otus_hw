package otus.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import otus.support.GuiceScoped;

public class Hooks {

    @Inject
    public GuiceScoped guiceScoped;


    @After
    public void close(){
        WebDriver driver = guiceScoped.getDriver();
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
