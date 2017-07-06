package com.zhenglinj.java.samples.basic;

import java.util.*;

public class Passbyvalue {
	public static void swap(List<Integer> lst0, List<Integer> lst1) {
		List<Integer> lst = lst0;
		lst0 = lst1;
		lst1 = lst;
		System.out.print(lst0);
		System.out.print(lst1);
		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> lst0 = Arrays.asList(0);
		List<Integer> lst1 = Arrays.asList(1);

		System.out.print(lst0);
		System.out.print(lst1);
		System.out.println();

		swap(lst0, lst1);

		System.out.print(lst0);
		System.out.print(lst1);
		System.out.println();
	}
}
