package com.frameworkdi;

import com.frameworkdi.dependencyInjectionFramework.Dependency;
import com.frameworkdi.dependencyInjectionFramework.injection.Injector;
import com.frameworkdi.dependencyTest.classes.ArgsEngineTest;
import com.frameworkdi.dependencyTest.classes.EngineImpl;
import com.frameworkdi.dependencyTest.interfaces.Engine;
import com.frameworkdi.dependencyTest.module.Module;

public class Main {
    public static void main(String[] args) {

        Injector injector = Dependency.getInjector(new Module());

        Engine engine = injector.inject(EngineImpl.class);
        engine.doSomething();

        ArgsEngineTest engineTest = injector.inject(ArgsEngineTest.class);
        engineTest.getEngine().doSomething();

        System.out.println(engine.toString().equals(engineTest.getEngine().toString()));
    }
}
