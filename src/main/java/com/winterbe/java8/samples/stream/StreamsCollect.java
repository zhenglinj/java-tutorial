package com.winterbe.java8.samples.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollect {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");

        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);

        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);

        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(collect);

        Map<Boolean, List<String>> passingFailingCollect = list.stream().collect(Collectors.partitioningBy(s -> s.length() >= 3));
        System.out.println(passingFailingCollect);
    }
}
