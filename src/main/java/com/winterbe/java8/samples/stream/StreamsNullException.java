package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsNullException {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3)); //Collections.emptyList();
        list.add(null);
        System.out.println(list);

        try {
            List<Integer> filterList = list.stream().filter(x -> x > 3).collect(Collectors.toList());
            System.out.println(filterList);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            Integer min = list.stream().filter(x -> x > 3).findFirst().orElse(null);
            System.out.println(min);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}
