package extensions;

import anotations.Driver;
import anotations.Page;
import factories.WebDriverFactory;
import listeners.WebDriverListener;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.MainPage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;

import java.util.Set;


public class UIExtensions implements BeforeEachCallback, AfterEachCallback {

    private  EventFiringWebDriver eventFiringWebDriver = null;

    private Set<Field> getField(Class<? extends Annotation> annotation, ExtensionContext extensionContext, Class<?> clazz){
        Set<Field> fields = new HashSet<>();
        Class<?> testClass = extensionContext.getTestClass().get();
        for (Field field: testClass.getDeclaredFields()){
            if(field.isAnnotationPresent(annotation)&& field.getType().getName().equals(clazz.getName())) {
                fields.add(field);
            };
        }
        return fields;
    }

//    public Set<Field> annotatedFieldsDriver(ExtensionContext extensionContext) {
//        return this.getField(Driver.class, extensionContext, WebDriver.class);
//    }

    public Set<Field> annotatedFieldsPage(ExtensionContext extensionContext) {
        return this.getField(Page.class, extensionContext, MainPage.class);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

        eventFiringWebDriver = new WebDriverFactory().create();
        eventFiringWebDriver.register(new WebDriverListener());

//        Set<Field> annotatedFieldsDriver = annotatedFieldsDriver(extensionContext);
//        for (Field fieldDriver: annotatedFieldsDriver){
//            fieldDriver.setAccessible(true);
//            fieldDriver.set(extensionContext.getTestInstance().get(), eventFiringWebDriver);
//        }

        Set<Field> annotatedFieldsPage = annotatedFieldsPage(extensionContext);
        for (Field fieldPage: annotatedFieldsPage){
            fieldPage.setAccessible(true);
            fieldPage.set(extensionContext.getTestInstance().get(), new MainPage(eventFiringWebDriver));
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        if(eventFiringWebDriver != null) {
            eventFiringWebDriver.close();
            eventFiringWebDriver.quit();
        }
    }
}
