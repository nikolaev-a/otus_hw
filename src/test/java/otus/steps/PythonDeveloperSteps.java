package otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Затем;
import otus.pages.PythonDeveloper;

public class PythonDeveloperSteps {

    @Inject
    public PythonDeveloper pythonDeveloper;

    @Затем("Проверим, что выбран нужный курс")
    public void elementRemoveHighlight() {
        pythonDeveloper.checkHeaderPage();
    }
}
