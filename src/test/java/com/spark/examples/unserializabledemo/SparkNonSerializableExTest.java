package com.spark.examples.unserializabledemo;

import com.spark.examples.unserializabledemo.util.UnserializableClass;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class SparkNonSerializableExTest {
    private static JavaSparkContext jsc;

    @BeforeClass
    public static void beforeClass() {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("test");

        SparkContext sc = new SparkContext(conf);
        jsc = JavaSparkContext.fromSparkContext(sc);
    }

    @AfterClass
    public static void afterClass() {
        jsc.close();
    }

    @Test(expected = org.apache.spark.SparkException.class)
    public void testUnserializableClassMethod() {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        UnserializableClass unserializableClass = new UnserializableClass();
        javaRDD.map(x -> unserializableClass.method(x)).collect().forEach(System.out::println);
    }

    @Test(expected = org.apache.spark.SparkException.class)
    public void testUnserializableClassObjectStaticMethod() {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        UnserializableClass unserializableClass = new UnserializableClass();
        javaRDD.map(x -> unserializableClass.staticMethod(x)).collect().forEach(System.out::println);
    }
}