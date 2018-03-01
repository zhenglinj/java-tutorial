package com.z.java.samples.basic;

import java.util.*;

public class Passbyvalue {
	public static void swap0(int obj0, int obj1) {
		int obj = obj0;
		obj0 = obj1;
		obj1 = obj;
		System.out.printf("%s %s\n", obj0, obj1);
	}

	public static <T> void swap(T obj0, T obj1) {
		T obj = obj0;
		obj0 = obj1;
		obj1 = obj;
		System.out.printf("%s %s\n", obj0, obj1);
	}

	public static <T> void swap1(T[] objs) {
		T obj = objs[0];
		objs[0] = objs[1];
		objs[1] = obj;
		System.out.printf("%s %s\n", objs[0], objs[1]);
	}

	public static void main(String[] args) {
		{
			List<Integer> obj0 = Arrays.asList(0);
			List<Integer> obj1 = Arrays.asList(1);

			System.out.println(obj0.toString() + obj1.toString());

			swap(obj0, obj1);

			System.out.println(obj0.toString() + obj1.toString());			
		}

	
		{
			int obj0 = 0;
			int obj1 = 1;

			System.out.printf("%s %s\n", obj0, obj1);

			swap0(obj0, obj1);

			System.out.printf("%s %s\n", obj0, obj1);	
		}
	}
}
