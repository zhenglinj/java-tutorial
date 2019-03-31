package com.frameworkaop.jdkproxytest.aopTest;

import java.lang.reflect.Method;

public class AdviceImpl implements Advice {
    long beginTime = 0;
    public void forwardMethod(Method method){
        System.out.println("Before ...");
        beginTime = System.currentTimeMillis();
    }

    public void backMethod(Method method){
        long endTime = System.currentTimeMillis();
        System.out.println("After method " + method.getName() + " running time of " + (endTime - beginTime));
    }
}
