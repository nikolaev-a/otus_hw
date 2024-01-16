package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageAbs<MainPage> {



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void checkPage() {
        System.out.println("checkPage");
    }
}
