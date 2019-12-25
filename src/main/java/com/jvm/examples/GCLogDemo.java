package com.jvm.examples;

/**
 * Created by zhenglj on 19/03/2018.
 */

/**
 * 33.125 [GC[DefNew 3324K- 152K 3712K  0.0025925 secs]3324K- 152K 11904K  0.0031680 secs]
 * 1 0 0.6 6 7 [F u l l G C[T e n u r e d 0 K- 2 1 0 K 1 0 2 4 0 K  0.0 1 4 9 1 4 2 s e c s]4603K- 210K 19456K  [Perm 2999K-  2999K 21248K ] 0.0150007 secs][Times user=0.01 sys=0.00 real=0.02 secs]
 */
public class GCLogDemo {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM ARGS:  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * <p>
     * output:
     * <p>
     * Heap
     * PSYoungGen      total 9216K, used 6979K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     * eden space 8192K, 85% used [0x00000007bf600000,0x00000007bfcd0fd8,0x00000007bfe00000)
     * from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
     * to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
     * ParOldGen       total 10240K, used 4096K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     * object space 10240K, 40% used [0x00000007bec00000,0x00000007bf000010,0x00000007bf600000)
     * Metaspace       used 2633K, capacity 4486K, committed 4864K, reserved 1056768K
     * class space    used 286K, capacity 386K, committed 512K, reserved 1048576K
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // One Minor GC
    }

    /**
     * VM ARGS:   -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        // the time when entering the old gen depends on -XX:MaxTenuringThreshold
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        // testAllocation();
        testTenuringThreshold();
    }
}
