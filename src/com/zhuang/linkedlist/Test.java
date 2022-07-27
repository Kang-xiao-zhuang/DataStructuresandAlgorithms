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
		System.out.println("---------------------------------");
		
		LinkedList2<Integer> list2 = new LinkedList2<>();
		list2.add(20);
		list2.add(0,10);
		list2.add(30);
		list2.add(list2.size(),40);
		list2.remove(1);
		System.out.println(list2); 
		System.out.println("---------------------------------");
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			arrayList.add(i);
		}
		
		for (int i = 0; i < 50; i++) {
			arrayList.remove(0);
		}
		
		System.out.println(arrayList);
		
	}

}
