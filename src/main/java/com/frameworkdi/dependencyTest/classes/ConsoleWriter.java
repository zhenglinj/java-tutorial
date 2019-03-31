package com.frameworkdi.dependencyTest.classes;

import com.frameworkdi.dependencyTest.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
