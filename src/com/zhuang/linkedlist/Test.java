package com.zhuang.linkedlist;

import com.zhuang.linkedlist.circle.CircleLinkedList;
import com.zhuang.linkedlist.circle.SingleCircleLinkedList;
import com.zhuang.tools.Asserts;

public class Test {

	public static void main(String[] args) {
		/*
		 * LinkedList<Integer> list1 = new LinkedList<>(); list1.add(20); list1.add(0,
		 * 10); list1.add(30); list1.add(list1.size(), 40); list1.remove(1);
		 * System.out.println(list1);
		 * System.out.println("---------------------------------");
		 * 
		 * LinkedList2<Integer> list2 = new LinkedList2<>(); list2.add(20); list2.add(0,
		 * 10); list2.add(30); list2.add(list2.size(), 40); list2.remove(1);
		 * System.out.println(list2);
		 * System.out.println("---------------------------------");
		 * 
		 * ArrayList<Integer> arrayList = new ArrayList<>(); for (int i = 0; i < 50;
		 * i++) { arrayList.add(i); }
		 * 
		 * for (int i = 0; i < 50; i++) { arrayList.remove(0); }
		 * 
		 * System.out.println(arrayList);
		 */
		testList(new ArrayList<>());
		testList(new LinkedList<>());

		testList(new SingleCircleLinkedList<>());
		testList(new CircleLinkedList<>());
		josephus();

	}

	public static void testList(List<Integer> list) {
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);

		list.add(0, 55); // [55, 11, 22, 33, 44]
		list.add(2, 66); // [55, 11, 66, 22, 33, 44]
		list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

		list.remove(0); // [11, 66, 22, 33, 44, 77]
		list.remove(2); // [11, 66, 33, 44, 77]
		list.remove(list.size() - 1); // [11, 66, 33, 44]

		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		Asserts.test(list.get(list.size() - 1) == 44);

		System.out.println(list);
	}

	public static void josephus() {
		CircleLinkedList<Integer> list = new CircleLinkedList<>();
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}

		// 指向头结点（指向1）
		list.reset();

		while (!list.isEmpty()) {
			list.next();
			list.next();
			System.out.println(list.remove());
		}
	}

}
