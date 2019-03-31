package com.frameworkdi.dependencyTest.classes;

import com.frameworkdi.dependencyInjectionFramework.injection.Inject;
import com.frameworkdi.dependencyTest.interfaces.Engine;
import com.frameworkdi.dependencyTest.interfaces.Reader;
import com.frameworkdi.dependencyTest.interfaces.Writer;

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
