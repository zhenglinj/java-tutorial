package com.oldratlee.fucking.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jerry Lee(oldratlee at gmail dot com)
 */
public class InvalidLongDemo {
    //volatile long count = 0;
    volatile AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        // LoadMaker.makeLoad();

        InvalidLongDemo demo = new InvalidLongDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for (int i = 0; ; i++) {
            long l = i;
            //demo.count = l << 32 | l;
            demo.count.set(l << 32 | l);
        }
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
        @Override
        public void run() {
            int c = 0;
            for (int i = 0; ; i++) {
                // long l = count;
                long l = count.get();
                long high = l >>> 32;
                long low = l & 0xFFFFFFFFL;
                if (high != low) {
                    c++;
                    System.err.printf("Fuck! Got invalid long!! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, high, low);
                } else {
                    // 如果去掉这个输出，则在我的开发机上没有观察到invalid long
                    System.out.printf("Emm... %s|%s\n", high, low);
                }
            }
        }
    }

}
