package com.java.samples.concurrency;

public class ThreadLocalDemo {
    public void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = ThreadLocal.withInitial(
                    () -> Thread.currentThread().getName()
            );

            @Override
            public void run() {
                super.run();
                String s = mStringThreadLocal.get();
                System.out.println(s);
                mStringThreadLocal.set("ThreadLocalString");
                s = mStringThreadLocal.get();
                System.out.println(s);
            }
        };

        t.start();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.testThreadLocal();
    }
}
