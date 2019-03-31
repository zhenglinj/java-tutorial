package com.frameworkaop.jdkproxytest.aopTest;

import com.frameworkaop.jdkproxytest.aopFramework.CustomizeProxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AopTest {
    public static void main(String args[]){
        List<String> target = new ArrayList<>();//创建目标类的实例对象
        Advice adviceImpl = new AdviceImpl();
        Collection proxy = (Collection) CustomizeProxy.getProxy(target, adviceImpl);//创建动态类
        proxy.add("aa");
        System.out.println(proxy.size());
        System.out.println(proxy.getClass().getName());
    }
}
