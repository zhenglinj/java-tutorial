package com.java.samples.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CdlCbDemo {
    private final static Logger logger = LoggerFactory.getLogger(CdlCbDemo.class);

    private static void testCountDownLatch() throws Exception {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDown = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("thread run");
                    try {
                        Thread.sleep(2000);
                        countDown.countDown();

                        logger.info("thread end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        countDown.await();
        long stop = System.currentTimeMillis();
        logger.info("main over total time={}", stop - start);
    }

    private static void testCyclicBarrier() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                logger.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                logger.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                logger.info("thread end do something");
            }
        }).start();

        logger.info("main thread");
    }

    public static void main(String[] args) {
        try {
            testCountDownLatch();
            testCyclicBarrier();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
