package com.frameworkaop.jdkproxytest.aopFramework;

import com.frameworkaop.jdkproxytest.aopTest.Advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomizeProxy {
    public CustomizeProxy() {
    }

    public static Object getProxy(final Object target, final Advice advice) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        advice.forwardMethod(method);
                        Object result = method.invoke(target, args);
                        advice.backMethod(method);

                        return result;
                    }
                }
        );
        return proxy;
    }
}