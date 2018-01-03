package com.di;

import com.di.dependencyInjectionFramework.Dependency;
import com.di.dependencyInjectionFramework.injection.Injector;
import com.di.dependencyTest.classes.ArgsEngineTest;
import com.di.dependencyTest.classes.EngineImpl;
import com.di.dependencyTest.interfaces.Engine;
import com.di.dependencyTest.module.Module;

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
