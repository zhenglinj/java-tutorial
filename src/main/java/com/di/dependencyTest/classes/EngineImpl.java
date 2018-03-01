package com.di.dependencyTest.classes;

import com.di.dependencyInjectionFramework.injection.Inject;
import com.di.dependencyTest.interfaces.Engine;
import com.di.dependencyTest.interfaces.Reader;
import com.di.dependencyTest.interfaces.Writer;

public class EngineImpl implements Engine {

    @Inject
    private Writer writer;

    @Inject
    private Reader reader;

    public EngineImpl() {
    }

    public EngineImpl(ArgsEngineTest test) {
    }

    public void doSomething(){
        this.writer.write(this.reader.read());
    }
}
