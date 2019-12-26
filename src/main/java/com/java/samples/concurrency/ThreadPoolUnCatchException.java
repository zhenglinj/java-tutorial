package com.java.samples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUnCatchException {
    private static ExecutorService pool = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        pool.execute(new Run1());
        pool.execute(new Run3());
//        pool.shutdown();
//
//        if (!pool.awaitTermination(1000, TimeUnit.SECONDS)) {
//            System.out.println("============ thread processing ============");
//        }
        System.out.println("============ main end ============");
    }

    private static class Run1 implements Runnable {
        @Override
        public void run() {
            System.out.println("============ 1 ============");
        }
    }

    private static class Run2 implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            do {
                count++;
                System.out.println(String.format("============ 2 ============(count: %d)", count));
                if (count == 10) {
                    System.out.println(1 / 0);
                }
            } while (count != 20);
        }
    }

    private static class Run3 implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            do {
                try {
                    count++;
                    System.out.println(String.format("============ 3 ============(count: %d)", count));
                    if (count == 10) {
                        System.out.println(1 / 0);
                    }
                } catch (RuntimeException ex) {
                    System.out.println(ex);
                }
            } while (count != 20);
        }
    }
}
