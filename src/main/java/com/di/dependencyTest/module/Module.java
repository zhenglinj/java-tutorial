package com.di.dependencyTest.module;

import com.di.dependencyInjectionFramework.module.AbstractModule;
import com.di.dependencyTest.classes.ConsoleReader;
import com.di.dependencyTest.classes.ConsoleWriter;
import com.di.dependencyTest.classes.EngineImpl;
import com.di.dependencyTest.interfaces.Engine;
import com.di.dependencyTest.interfaces.Reader;
import com.di.dependencyTest.interfaces.Writer;

public class Module extends AbstractModule {

    @Override
    public void configure() {
        createMapping(Writer.class, ConsoleWriter.class);
        createMapping(Reader.class, ConsoleReader.class);
        createMapping(Engine.class, EngineImpl.class);
    }
}
