package otus.pages;

import com.google.inject.Inject;
import otus.anotations.URLPrefix;
import otus.support.GuiceScoped;

@URLPrefix("/lessons/ml-specialization/")
public class MachineLearningPage extends BasePageAbs<MachineLearningPage> {

    @Inject
    public MachineLearningPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
