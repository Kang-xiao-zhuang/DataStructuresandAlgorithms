package com.zhuang.dynamic_list;


public class Test {
	
	public static void main(String[] args) {
		//测试Eclipse
		ArrayList<Person> arrayList = new ArrayList<>();
		arrayList.add(new Person("ZK123",12));
		arrayList.add(null);
		System.out.println(arrayList.indexOf(null));
		System.out.println(arrayList.toString());
	}
}
