package com.jvm.java.examples;

/**
 * Created by zhenglj on 06/03/2018.
 */

/**
 * 1. The objects can save ourselves while GC
 * 2. Just one chance since every object's finalize() will be called once
 * @author zzm
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize mehtod executed ");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        //
        SAVE_HOOK = null;
        System.gc();
        //  finalize            0.5
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead  ");
        }
        //
        SAVE_HOOK = null;
        System.gc();
        //  finalize            0.5
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead  ");
        }
    }
}
