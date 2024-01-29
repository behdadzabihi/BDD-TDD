package org.sample.bdd.tdd.acceptance.test;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import java.util.Collections;

public class DefineNewCourseRunner extends ConfigurableEmbedder {

    Embedder embedder;
    @Override
    @Test
    public void run() throws Throwable {
        embedder=configuredEmbedder();
        embedder.configuration();
        System.out.println("I am run method");
        String storyPath="NewCourse.story";
        embedder.runStoriesAsPaths(Collections.singletonList(storyPath));
    }

    public Configuration configuration(){
        return new MostUsefulConfiguration();
    }

    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(),new DefineNewCourse());
    }
}
