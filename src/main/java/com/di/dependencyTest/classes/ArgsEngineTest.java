package com.di.dependencyTest.classes;

import com.di.dependencyInjectionFramework.injection.Inject;
import com.di.dependencyTest.interfaces.Engine;

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
