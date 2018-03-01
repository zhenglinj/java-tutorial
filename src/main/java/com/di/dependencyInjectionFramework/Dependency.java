package com.di.dependencyInjectionFramework;

import com.di.dependencyInjectionFramework.injection.Injector;
import com.di.dependencyInjectionFramework.module.Module;

public class Dependency {
    public static Injector getInjector(Module module) {
        module.configure();
        return new Injector(module);
    }
}
