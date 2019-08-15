package com.spark.examples.unserializabledemo;

import com.spark.examples.unserializabledemo.util.SerializableClass;
import com.spark.examples.unserializabledemo.util.UnserializableClass;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class SparkSerializableTest {
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

    @Test
    public void testNewUnserializableClassMethod() {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        javaRDD.map(x -> new UnserializableClass().method(x)).collect().forEach(System.out::println);
    }

    @Test
    public void testUnserializableClassStaticMethod() {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        javaRDD.map(x -> UnserializableClass.staticMethod(x)).collect().forEach(System.out::println);
    }

    @Test
    public void testSerializableClassMethod() {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        SerializableClass serializableClass = new SerializableClass();
        javaRDD.map(x -> serializableClass.method(x)).collect().forEach(System.out::println);
    }
}