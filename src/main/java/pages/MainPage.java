package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @FindBy(xpath = "//span[contains(., 'С') and contains(., 'месяцев')]")
    List<WebElement> coursesStartTime;


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

    public MainPage checkPageOpeningMarker() {
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
            filteredCourses.get(0).click();
        }
        return this;
    }

    public MainPage filterByCourseIsTimeStart() {
        List<String> dateStrings = coursesStartTime.stream()
                .map(WebElement::getText)
                .map(dateString -> dateString.substring(dateString.indexOf("С ") + 2, dateString.lastIndexOf(" 1")))
                .collect(Collectors.toList());

        List<LocalDate> courseDates = dateStrings.stream()
                .map(Helpers::parseDateWithMonthFromText)
                .collect(Collectors.toList());

        LocalDate earliestDate = courseDates.stream()
                .reduce((date1, date2) -> date1.isBefore(date2) ? date1 : date2)
                .orElse(null);

        if (earliestDate != null) {
            String formEarliestDate = earliestDate.format(DateTimeFormatter.ofPattern("d MMMM"));
            WebElement earliestCard =
                    driver.findElement(By.xpath(String.format("//span[contains(., '%s')]", formEarliestDate)));
            earliestCard.click();
        }
        return this;
    }
}