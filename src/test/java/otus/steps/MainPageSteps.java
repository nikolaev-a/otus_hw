package otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Ктомуже;
import otus.pages.MainPage;

public class MainPageSteps {

    @Inject
    public MainPage mainPage;

    @Пусть("Открыта главная страница")
    public void openMainPage() {
        mainPage.open()
                .checkPageOpeningMarker();
    }

    @Тогда("Реализуем подсветку элемента")
    public void elementHighlighting() {
        mainPage.highlightElement();
    }

    @Затем("Снимем подсветку элемента")
    public void elementRemoveHighlight() {
        mainPage.removeHighlightElement();
    }

    @Ктомуже("Выберем первый обучающий курс по времени")
    public void choosingByCourseIsTimeStart() {
        mainPage.filterByCourseIsTimeStart();
    }

    @Тогда("Выберем обучающий курс {string}")
    public void choosingCourseByName(String courseName) {
        mainPage.filterByCourseName(courseName);
    }

    @Тогда("Выберем обучающий курс по дате {string}")
    public void choosingByCourseData(String courseData) {
        mainPage.filterByCourseData(courseData);
    }

    @Тогда("Выберем обучающий курс c помощью Action")
    public void choosingCourseUsingAction() {
        mainPage.selectCourseUsingAction();
    }
}