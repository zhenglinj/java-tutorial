package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomShuffle {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = IntStream.range(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}
