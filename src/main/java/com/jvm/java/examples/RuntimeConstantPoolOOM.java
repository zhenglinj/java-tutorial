package com.jvm.java.examples;

import java.util.*;

/**
 * Created by zhenglj on 22/02/2018.
 */

/**
 * VM Args -XX PermSize=10M-XX MaxPermSize=10M
 * @author zzm
 */
public class RuntimeConstantPoolOOM {
    public static void runtimeConstantPoolOOM() {
        // List           Full GC
        List<String> list = new ArrayList<String>();
        // 10MB PermSize integer       OOM
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void stringIntern() {
        String str1 = new StringBuilder("计算机").append("技术").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    public static void main(String[] args) {
        stringIntern();
    }
}
