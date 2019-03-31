package com.frameworkaop.jdkproxytest.aopTest;

import java.lang.reflect.Method;

public interface Advice {
    void forwardMethod(Method method);
    void backMethod(Method method);
}
