package com.zhenglinj.java.samples.collections;

import java.util.Map.Entry;
import java.util.*;

public class AllCollections {

	private static void runDemo() {
		{
			List<Object> collection = Arrays.asList("Hello", "Java");
			Iterator it = collection.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				System.out.println(obj);
			}

			ArrayList<String> strs = new ArrayList<String>();
			strs.add("Hello");
			strs.add("World");

			for (String str : strs) {
				System.out.println(str);
			}

			String allStr = String.join(", ", strs);
			System.out.println(allStr);
			System.out.println("\n");
		}

		{
			Vector<String> vct = new Vector<String>();
			// adding elements to the end
			vct.add("First");
			vct.add("Second");
			vct.add("Third");
			vct.add("Random");

			Iterator<String> itr = vct.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}

			System.out.println(vct);
			List<String> list = new ArrayList<String>();
			list.add("one");
			list.add("two");
			vct.addAll(list);
			System.out.println(vct);

			List<String> lst = new ArrayList<String>();
			lst.add("Second");
			lst.add("Random");
			System.out.println("Does vector contains all list elements?: " + vct.containsAll(lst));
			lst.add("xxx");
			System.out.println("Does vector contains all list elements?: " + vct.containsAll(lst));

			List<String> sublist = vct.subList(2, 4);
			System.out.println("Sub List: " + sublist);

			List<Employee> emps = new ArrayList<Employee>();
			emps.add(new Employee(1, "Ram", 3000));
			emps.add(new Employee(2, "John", 6000));
			emps.add(new Employee(3, "Crish", 2000));
			emps.add(new Employee(4, "Tom", 2400));
			Collections.sort(emps, new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					if (e1.getSalary() == e2.getSalary()) {
						return 0;
					} else if (e1.getSalary() > e2.getSalary()) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			System.out.println(emps);
			Collections.reverse(emps);
			Collections.shuffle(emps);
			Collections.swap(emps, 1, 3);
			System.out.println(emps);
			System.out.println("\n");
		}

		{
			LinkedList<String> arrl = new LinkedList<String>();
			arrl.add("First");
			arrl.add("Second");
			arrl.add("Third");
			arrl.add("Random");
			System.out.println(arrl);

			arrl.push("push element");
			System.out.println("After push operation:");
			System.out.println(arrl);
			arrl.pop();
			System.out.println("After pop operation:");
			System.out.println(arrl);

			System.out.println("First Element: " + arrl.element());
			System.out.println("First Element: " + arrl.getFirst());
			System.out.println("First Element: " + arrl.peek());
			System.out.println("First Element: " + arrl.peekFirst());
			System.out.println("Last Element: " + arrl.getLast());
			System.out.println("Last Element: " + arrl.peekLast());

			System.out.println("Adding element at first position...");
			arrl.addFirst("I am first");
			System.out.println(arrl);
			System.out.println("Adding element at last position...");
			arrl.addLast("I am last");
			System.out.println(arrl);

			System.out.println("Remov() method:" + arrl.remove());
			System.out.println("After remove() method call:");
			System.out.println(arrl);
			System.out.println("remove(index) method:" + arrl.remove(1));
			System.out.println("After remove(index) method call:");
			System.out.println(arrl);
			System.out.println("Remov(object) method:" + arrl.remove("six"));
			System.out.println("After remove(object) method call:");
			System.out.println(arrl);
			System.out.println("removeFirst() method:" + arrl.removeFirst());
			System.out.println("After removeFirst() method call:");
			System.out.println(arrl);
			System.out.println("removeFirstOccurrence() method:" + arrl.removeFirstOccurrence("eight"));
			System.out.println("After removeFirstOccurrence() method call:");
			System.out.println(arrl);
			System.out.println("removeLast() method:" + arrl.removeLast());
			System.out.println("After removeLast() method call:");
			System.out.println(arrl);
			System.out.println("removeLastOccurrence() method:" + arrl.removeLastOccurrence("five"));
			System.out.println("After removeLastOccurrence() method call:");
			System.out.println(arrl);
			System.out.println("\n");
		}

		{
			Hashtable<String, String> hm = new Hashtable<String, String>();
			// add key-value pair to Hashtable
			hm.put("first", "FIRST INSERTED");
			hm.put("second", "SECOND INSERTED");
			hm.put("third", "THIRD INSERTED");

			System.out.println(hm);
			HashMap<String, String> subMap = new HashMap<String, String>();
			subMap.put("first", "S1 VALUE");
			subMap.put("fourth", "S2 VALUE");
			hm.putAll(subMap);
			System.out.println(hm);

			Set<String> keySet = hm.keySet();
			for (String key : keySet) {
				System.out.println(key + "\t=> " + hm.get(key));
			}
			Set<Entry<String, String>> entries = hm.entrySet();
			for (Entry<String, String> ent : entries) {
				System.out.println(ent.getKey() + "\t-> " + ent.getValue());
			}
			Enumeration<String> keys = hm.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				System.out.println(key + "\tvalue is: " + hm.get(key));
			}

			Hashtable<Employee, String> tm = new Hashtable<Employee, String>();
			tm.put(new Employee(134, "Ram", 3000), "RAM");
			tm.put(new Employee(235, "John", 6000), "JOHN");
			tm.put(new Employee(876, "Crish", 2000), "CRISH");
			tm.put(new Employee(512, "Tom", 2400), "TOM");
			System.out.println("Fecthing value by creating new key:");

			Employee e = new Employee(512, "Tom", 2400);
			System.out.println(e + "\t-> " + tm.get(e));
			System.out.println("\n");
		}

		{
			HashSet<String> hs = new HashSet<String>();
			// add elements to HashSet
			hs.add("first");
			hs.add("second");
			hs.add("third");
			hs.add("apple");
			hs.add("rat");
			System.out.println(hs);
			HashSet<String> subSet = new HashSet<String>();
			subSet.add("rat");
			subSet.add("second");
			subSet.add("first");
			hs.retainAll(subSet);
			System.out.println("HashSet content:");
			System.out.println(hs);
			System.out.println("\n");
		}

		{
			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			// add elements to HashSet
			lhs.add("first");
			lhs.add("second");
			lhs.add("third");
			System.out.println(lhs);
			System.out.println("LinkedHashSet size: " + lhs.size());
			System.out.println("Is LinkedHashSet emplty? : " + lhs.isEmpty());
			System.out.println("\n");
		}

		{
			TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String str1, String str2) {
					return str1.compareTo(str2);
				}
			});
			ts.add("RED");
			ts.add("ORANGE");
			ts.add("BLUE");
			ts.add("GREEN");
			ts.add("WHITE");
			ts.add("BROWN");
			ts.add("YELLOW");
			ts.add("BLACK");
			System.out.println(ts);
			Set<String> subSet = ts.subSet("GREEN", "WHITE");
			System.out.println("sub set: " + subSet);
			subSet = ts.subSet("GREEN", true, "WHITE", true);
			System.out.println("sub set: " + subSet);
			subSet = ts.subSet("GREEN", false, "WHITE", true);
			System.out.println("sub set: " + subSet);

			// TODO: demo
			// By using name comparator (String comparison)
			TreeSet<Employee> nameComp = new TreeSet<Employee>(new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getName().compareTo(e2.getName());
				}
			});
			nameComp.add(new Employee(1, "Ram", 3000));
			nameComp.add(new Employee(2, "John", 6000));
			nameComp.add(new Employee(3, "Crish", 2000));
			nameComp.add(new Employee(4, "Tom", 2400));
			// adding duplicate entry
			nameComp.add(new Employee(4, "Tom", 2400));
			for (Employee e : nameComp) {
				System.out.println(e);
			}
			System.out.println("===========================");
			// By using salary comparator (int comparison)
			TreeSet<Employee> salComp = new TreeSet<Employee>(new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					if (e1.getSalary() == e2.getSalary()) {
						return 0;
					} else if (e1.getSalary() > e2.getSalary()) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			salComp.add(new Employee(1, "Ram", 3000));
			salComp.add(new Employee(2, "John", 6000));
			salComp.add(new Employee(3, "Crish", 2000));
			salComp.add(new Employee(4, "Tom", 2400));
			for (Employee e : salComp) {
				System.out.println(e);
			}
			System.out.println("\n");
		}

		{
			// the treemap sorts by key
			TreeMap<String, String> hm = new TreeMap<String, String>(new Comparator<String>() {
				@Override
				public int compare(String str1, String str2) {
					return str1.compareTo(str2);
				}
			});
			// add key-value pair to TreeMap
			hm.put("java", "language");
			hm.put("computer", "machine");
			hm.put("india", "country");
			hm.put("mango", "fruit");
			hm.put("game", "cricket");
			for (Entry<String, String> e : hm.entrySet())
				System.out.print(e + " ");
			System.out.println();
			System.out.println("TreeMap Entries:");
			System.out.println(hm);
			Map<String, String> subMap1 = hm.subMap("game", "java");
			System.out.println("Sub-Map enties:");
			System.out.println(subMap1);
			// how to get lower boundary also part of sub-map
			Map<String, String> subMap2 = hm.subMap("game", true, "java", true);
			System.out.println("Sub-Map enties:");
			System.out.println(subMap2);
			// how to omit upper boundary in the sub-map
			Map<String, String> subMap3 = hm.subMap("game", false, "java", true);
			System.out.println("Sub-Map enties:");
			System.out.println(subMap3);

			System.out.println("\n");
		}

		{
			List<String> skills = new ArrayList<String>();
			skills.add("java");
			skills.add("c");
			skills.add("c++");
			System.out.println("Initial list:" + skills);
			Collections.addAll(skills, "perl", "php");
			System.out.println("After adding elements:" + skills);
			String[] strArr = { ".Net", "unix" };
			Collections.addAll(skills, strArr);
			System.out.println("After adding array:" + skills);

			Map myMap = new HashMap();
			myMap.put("one", 1);
			myMap.put("two", 2);
			myMap.put("three", 3);
			myMap.put("four", 4);
			Map chkMap = Collections.checkedMap(myMap, String.class, Integer.class);
			System.out.println("Checked map content: " + chkMap);
			// you can add any type of elements to myMap object
			myMap.put(10, "ten");
			// you cannot add any type of elements to chkMap object, doing so
			// throws ClassCastException
			try {
				chkMap.put(10, "ten"); // throws ClassCastException
			} catch (ClassCastException ex) {
				System.out.println(ex);
			}

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

			System.out.println("\n");
		}

		{
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		runDemo();
	}
}
