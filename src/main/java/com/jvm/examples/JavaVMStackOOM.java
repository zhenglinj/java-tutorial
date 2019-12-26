package com.jvm.examples;

/**
 * Created by zhenglj on 16/02/2018.
 */

/**
 * VM Args -Xss2M
 *
 * @author zzm
 * @warning running this program cause system death.
 * Exception in thread "main" java.lang.OutOfMemoryError unable to create new native thread
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
