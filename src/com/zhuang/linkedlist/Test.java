package com.zhuang.linkedlist;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(20);
		list1.add(0,10);
		list1.add(30);
		list1.add(list1.size(),40);
		list1.remove(1);
		System.out.println(list1);

	}

}
