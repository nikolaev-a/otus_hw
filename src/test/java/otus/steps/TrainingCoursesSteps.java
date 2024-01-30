package otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import otus.pages.TrainingCoursesPage;

public class TrainingCoursesSteps {

    @Inject
    public TrainingCoursesPage trainingCoursesPage;

    @Пусть("Открыта страница подготовительных курсов")
    public void openTrainingCoursesPage() {
        trainingCoursesPage.open()
                .checkPageOpeningMarker();
    }

    @Тогда("Выбираем самую высокую цену за курс")
    public void choiceFilterByCourseMaxByPrice() {
        trainingCoursesPage.filterByCourseMaxByPrice();
    }

    @И("Выбираем самую низкую цену за курс")
    public void choiceFilterByCourseMinByPrice() {
        trainingCoursesPage.filterByCourseMinByPrice();
    }
}
