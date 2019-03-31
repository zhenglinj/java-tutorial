package com.frameworkdi.dependencyTest.module;

import com.frameworkdi.dependencyInjectionFramework.module.AbstractModule;
import com.frameworkdi.dependencyTest.classes.ConsoleReader;
import com.frameworkdi.dependencyTest.classes.ConsoleWriter;
import com.frameworkdi.dependencyTest.classes.EngineImpl;
import com.frameworkdi.dependencyTest.interfaces.Engine;
import com.frameworkdi.dependencyTest.interfaces.Reader;
import com.frameworkdi.dependencyTest.interfaces.Writer;

public class Module extends AbstractModule {

    @Override
    public void configure() {
        createMapping(Writer.class, ConsoleWriter.class);
        createMapping(Reader.class, ConsoleReader.class);
        createMapping(Engine.class, EngineImpl.class);
    }
}
