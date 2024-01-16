package extensions;

import anotations.Driver;
import factories.WebDriverFactory;
import listeners.WebDriverListener;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;

import java.util.Set;


public class UIExtensions implements BeforeEachCallback, AfterEachCallback {

    private  EventFiringWebDriver eventFiringWebDriver = null;

    private Set<Field> getField(Class<? extends Annotation> annotation, ExtensionContext extensionContext){
        Set<Field> fields = new HashSet<>();
        Class<?> testClass = extensionContext.getTestClass().get();
        for (Field field: testClass.getDeclaredFields()){
            if(field.isAnnotationPresent(annotation)&& field.getType().getName().equals(WebDriver.class.getName())) {
                fields.add(field);
            };
        }
        return fields;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

        Set<Field> annotatedFields = this.getField(Driver.class, extensionContext);

        eventFiringWebDriver = new WebDriverFactory().create();
        eventFiringWebDriver.register(new WebDriverListener());

        for (Field field: annotatedFields){
            field.setAccessible(true);
            field.set(extensionContext.getTestInstance().get(), eventFiringWebDriver);
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
