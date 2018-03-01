package com.z.java.samples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedCollections {

	private static void runDemo() {
		// common thread safe collections
		// - Java 1.0 Hashtable, Vector, Stack
		// - Java 1.2 Collections.synchronizedXxx()
		// - Java 5.0 concurrency collections
		{

			System.out.println("\n");
		}

		{
			// synchronized is thread-safe
			List<String> li = new ArrayList<String>();
			List<String> synLi = Collections.synchronizedList(li);
			System.out.println("Synchronized list got created...");
			Set<String> ss = new HashSet<String>();
			Set<String> synSet = Collections.synchronizedSet(ss);
			System.out.println("Synchronized set got created...");
			Map<String, String> mp = new HashMap<String, String>();
			Map<String, String> synMapt = Collections.synchronizedMap(mp);
			System.out.println("Synchronized map got created...");

			System.out.println("\n");
		}

		{
			ConcurrentHashMap<String, Employee> m = new ConcurrentHashMap<String, Employee>();
			m.put("Ram", new Employee(1, "Ram", 3000));
			m.put("John", new Employee(2, "John", 6000));
			m.put("Crish", new Employee(3, "Crish", 2000));
			m.put("Tom", new Employee(4, "Tom", 2400));

			for (Entry<String, Employee> e : m.entrySet()) {
				System.out.println(e.getKey() + "=" + e.getValue());
			}

			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		runDemo();
	}
}
