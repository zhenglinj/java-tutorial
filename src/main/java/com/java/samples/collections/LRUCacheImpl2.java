package com.java.samples.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl2<T> extends LinkedHashMap<Integer, T> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public LRUCacheImpl2(int capacity, float loadFactor) {
		// LinkedHashMap(int capacity, float fillRatio, boolean Order)
		// If Order is true, then access order is used. If Order is false, then insertion order is used.
		super(capacity, loadFactor, true);
		this.capacity = capacity;
	}

	/**
	 * removeEldestEntry() should be overridden by the user, otherwise it will
	 * not remove the oldest object from the Map.
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, T> eldest) {
		return size() > this.capacity;
	}

	public static void main(String arg[]) {
		LRUCacheImpl2<String> lruCache = new LRUCacheImpl2<String>(4, 0.75f);
//		LinkedHashMap<Integer, String> lruCache = new LinkedHashMap<Integer, String>(4, 0.75f, true) {
//			@Override
//			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
//				return size() > 4;
//			}
//		};

		lruCache.put(1, "Object1");
		lruCache.put(2, "Object2");
		lruCache.put(3, "Object3");
		System.out.println(lruCache.get(1));
		lruCache.put(4, "Object4");
		System.out.println(lruCache);
		// lruCache.forEach((k, v) -> { System.out.println(k + ":" + v); });
		lruCache.put(5, "Object5");
		System.out.println(lruCache.get(2));
		lruCache.put(6, "Object6");
		System.out.println(lruCache);
		System.out.println(lruCache.get(4));
		lruCache.put(7, "Object7");
		lruCache.put(8, "Object8");
		System.out.println(lruCache);
	}
}
