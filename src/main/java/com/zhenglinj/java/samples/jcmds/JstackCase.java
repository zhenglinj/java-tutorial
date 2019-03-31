package com.zhenglinj.java.samples.jcmds;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JstackCase {

    public static Executor executor = Executors.newFixedThreadPool(4);
    public static Object object = new Object();

    public static void main(String[] args) {
        LoopTask task1 = new LoopTask();
        LoopTask task2 = new LoopTask();
        executor.execute(task1);
        executor.execute(task2);
    }

    static class LoopTask implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                int i = 0;
                while (true) {
                    i++;
                }
            }
        }
    }
}
