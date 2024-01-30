package otus.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import otus.anotations.URLPrefix;
import otus.support.GuiceScoped;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@URLPrefix("/online/")
public class TrainingCoursesPage extends BasePageAbs<TrainingCoursesPage> {

    @Inject
    public TrainingCoursesPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @FindBy(xpath = "//div[@class='lessons__new-item-bottom']")
    List<WebElement> coursePrice;

    @FindBy(xpath = "//h1")
    WebElement trainingCoursesPageMarker;

    public TrainingCoursesPage filterByCourseMaxByPrice() {
        Double maxPrice = coursePrice.stream()
                .map(el -> Double.parseDouble(el.getText().replaceAll("[^\\d]+", "")))
                .filter(el-> el > 0).max(Double::compare)
                .orElse(0.0);
        System.out.println("Самая высокая цена за курс: " + maxPrice + " ₽");

        return this;
    }

    public TrainingCoursesPage filterByCourseMinByPrice() {
        Double minPrice = coursePrice.stream()
                .map(el -> Double.parseDouble(el.getText().replaceAll("[^\\d]+", "")))
                .filter(el-> el > 0).min(Double::compare)
                .orElse(0.0);
        System.out.println("Самая низкая цена за курс: " + minPrice + " ₽");

        return this;
    }

    public TrainingCoursesPage checkPageOpeningMarker() {
        wait.waitForElementVisible(trainingCoursesPageMarker);
        assertTrue(trainingCoursesPageMarker.isDisplayed());
        System.out.println("[ИНФОРМАЦИЯ]: произведена успешная проверка открытия страницы по маркеру"
                + trainingCoursesPageMarker);
        return this;
    }
}