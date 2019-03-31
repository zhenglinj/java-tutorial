package com.frameworkdi.dependencyTest.classes;

import com.frameworkdi.dependencyInjectionFramework.injection.Inject;
import com.frameworkdi.dependencyTest.interfaces.Engine;

public class ArgsEngineTest {

    private Engine engine;

    @Inject
    public ArgsEngineTest(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
