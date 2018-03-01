package com.di.dependencyTest.classes;

import com.di.dependencyTest.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
