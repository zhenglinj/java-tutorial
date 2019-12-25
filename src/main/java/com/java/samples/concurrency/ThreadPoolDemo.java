package com.java.samples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * thread pool demo
 */
public class ThreadPoolDemo {
    private static volatile AtomicInteger counter = new AtomicInteger(0);
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public ThreadPoolDemo() {

    }

    private static class Job implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Job " + counter.getAndIncrement() + " is running");
        }
    }

    private void start() {
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i <= 5; i++) {
                pool.execute(new Job());
            }

            pool.shutdown();

            while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Thread pool is running...");
            }
            long end = System.currentTimeMillis();
            System.out.println("Total used time: " + (end - start));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        try {
            demo.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
