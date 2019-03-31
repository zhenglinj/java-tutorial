package com.frameworkdi.dependencyInjectionFramework;

import com.frameworkdi.dependencyInjectionFramework.injection.Injector;
import com.frameworkdi.dependencyInjectionFramework.module.Module;

public class Dependency {
    public static Injector getInjector(Module module) {
        module.configure();
        return new Injector(module);
    }
}
