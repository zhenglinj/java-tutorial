package com.zhenglinj.java.samples.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final static Lock LOCK = new ReentrantLock();
}
