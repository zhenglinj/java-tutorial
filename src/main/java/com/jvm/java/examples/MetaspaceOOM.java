package com.jvm.java.examples;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaspaceOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, objects);
                }
            });
            enhancer.create();
        }
    }
}

//Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
//    at java.lang.Class.forName0(Native Method)
//    at java.lang.Class.forName(Class.java:348)
//    at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:467)
//    at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:339)
//    at net.sf.cglib.proxy.Enhancer.generate(Enhancer.java:492)
//    at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:117)
//    at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:294)
//    at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
//    at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:305)
//    at com.jvm.java.examples.MetaspaceOOM.main(MetaspaceOOM.java:21)
