package com.java.samples.concurrency;

import java.util.concurrent.ArrayBlockingQueue;

public class SynQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
            queue.put(4);
            while (queue.size() > 0) {
                Integer el = (Integer) queue.poll();
                System.out.println(el);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
