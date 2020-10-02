package com.tngtech.jgiven.integration.spring.junit5;

import com.tngtech.jgiven.integration.spring.SpringStageCreator;
import com.tngtech.jgiven.junit5.SimpleScenarioTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Base class for Spring 5 and JUnit 5 test with only one stage class parameter.
 * <p>Taken from <a href="https://github.com/TNG/JGiven/tree/master/jgiven-spring-junit5">jgiven-spring-junit5</a>
 * source while we wait for artifact to be published.</p>
 *
 * @param <STAGE> the stage class
 * @since 1.0.0
 */
@ExtendWith(SpringExtension.class)
public class SimpleSpringScenarioTest<STAGE> extends
        SimpleScenarioTest<STAGE> implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        getScenario().setStageCreator(beanFactory.getBean(SpringStageCreator.class));
    }
}