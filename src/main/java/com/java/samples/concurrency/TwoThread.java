package com.java.samples.concurrency;

import java.util.concurrent.locks.*;

// 两个线程交替打印1-100
public class TwoThread {
    private int start = 1;

    private volatile int next = 1;

    /**
     * 保证内存可见性
     * 其实用锁了之后也可以保证可见性 这里用不用 volatile 都一样
     */
    private volatile boolean flag = false;
    /**
     * 重入锁
     */
    private final static Lock LOCK = new ReentrantLock();

    public TwoThread() {
    }

    private void printValue(int start) {
        Thread current = Thread.currentThread();
        while (start <= 100) {
            if (next == start) {
                try {
                    LOCK.lock();
                    System.out.println("thread" + current.getId() + ": " + start);
                    start += 2;
                    next++;
                } finally {
                    LOCK.unlock();
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run1() {
        start = 1;
        Thread t1 = new Thread(() -> printValue(1));
        Thread t2 = new Thread(() -> printValue(2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printValue(boolean target) {
        Thread current = Thread.currentThread();
        while (start <= 100) {
            if (flag == target) {
                try {
                    LOCK.lock();
                    System.out.println("thread" + current.getId() + ": " + start);
                    start++;
                    flag = !flag;
                } finally {
                    LOCK.unlock();
                }
            } else {
                try {
                    //防止线程空转
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run2() {
        start = 1;
        Thread t1 = new Thread(() -> printValue(true));
        Thread t2 = new Thread(() -> printValue(false));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printValueNotify(boolean target) {
        Thread current = Thread.currentThread();
        while (start <= 100) {
            synchronized (TwoThread.class) {
                if (flag == target) {
                    System.out.println("thread" + current.getId() + ": " + start);
                    start++;
                    flag = !flag;
                    TwoThread.class.notify();
                } else {
                    try {
                        TwoThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void run3() {
        start = 1;
        Thread t1 = new Thread(() -> printValueNotify(true));
        Thread t2 = new Thread(() -> printValueNotify(false));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long timeIt(Runnable runnable) {
        long startTime = System.nanoTime();

        runnable.run();

        long stopTime = System.nanoTime();
        long runTime = stopTime - startTime;

        return runTime;
    }

    public static void main(String[] args) {
        long runTime1, runTime2, runTime3;
        TwoThread tt = new TwoThread();

        runTime1 = timeIt(() -> tt.run1());
        runTime2 = timeIt(() -> tt.run2());
        runTime3 = timeIt(() -> tt.run2());

        System.out.println("Run time(ns): " + runTime1 + ", " + runTime2 + ", " + runTime3);
    }
}
