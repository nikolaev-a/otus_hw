package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MainPage extends BasePageAbs<MainPage> {

    Waiter wait = new Waiter(driver);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[contains(.,'Natural Language Processing (NLP)')]")
    WebElement languageProcessing;

    @FindBy(xpath = "//h2[contains(.,'Популярные курсы')]")
    WebElement pageOpeningMarker;

    @FindBy(xpath = "//h5")
    List<WebElement> courses;

    public MainPage highlightElement() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red';", languageProcessing);
        System.out.println("[ИНФОРМАЦИЯ]: реализована подсветка элемента " + languageProcessing);
        return this;
    }

    public MainPage removeHighlightElement() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", languageProcessing);
        System.out.println("[ИНФОРМАЦИЯ]: подсветка элемента снята " + languageProcessing);
        return this;
    }

    public MainPage checkPageOpeningMarker() throws InterruptedException {
        wait.waitForElementVisible(pageOpeningMarker);
        assertTrue(pageOpeningMarker.isDisplayed());
        return this;
    }

    public MainPage filterByCourseName(String courseName) {
        List<WebElement> filteredCourses = courses.stream().filter(element ->
                element.getText().contains(courseName)).collect(Collectors.toList());
        if(filteredCourses.isEmpty()) {
            System.out.printf("[ИНФОРМАЦИЯ]: страница не содержит выбранного курса '%s'\n", courseName);
        }
        else if(filteredCourses.size() > 1) {
            System.out.printf("[ИНФОРМАЦИЯ]: страница содержит дубликаты выбранного курса '%s'\n", courseName);
            for (WebElement course: filteredCourses){
                System.out.println("[ИНФОРМАЦИЯ]: дубликаты - " + course.getText());
            }
        } else if(filteredCourses.get(0).getText().equals(courseName)){
            System.out.printf("[ИНФОРМАЦИЯ]: страница содержит выбранный курс '%s'\n", courseName);
        }
        return this;
    }
}
