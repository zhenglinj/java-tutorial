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

import java.io.IOException;
import java.util.Arrays;

public class SparkSerializableKryoTest {
    private static JavaSparkContext jsc;

    @BeforeClass
    public static void beforeClass() {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("test");

        // 使用Kryo序列化库
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        // 在Kryo序列化库中注册自定义的类集合
        // conf.set("spark.kryo.registrator", ToKryoRegistrator.class.getName());
        conf.registerKryoClasses(new Class[] {
                com.spark.examples.unserializabledemo.util.UnserializableClass.class,
                com.spark.examples.unserializabledemo.util.SerializableClass.class
        });

        SparkContext sc = new SparkContext(conf);
        jsc = JavaSparkContext.fromSparkContext(sc);
    }

    @AfterClass
    public static void afterClass() {
        jsc.close();
    }

    @Test(expected = org.apache.spark.SparkException.class)
    public void testUnserializableClassMethod() throws IOException {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        UnserializableClass unserializableClass = new UnserializableClass();
        javaRDD.map(x -> unserializableClass.method(x)).collect().forEach(System.out::println);
    }

    @Test
    public void testSerializableClassMethod() throws IOException {
        JavaRDD<Integer> javaRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        SerializableClass serializableClass = new SerializableClass();
        javaRDD.map(x -> serializableClass.method(x)).collect().forEach(System.out::println);
    }
}
