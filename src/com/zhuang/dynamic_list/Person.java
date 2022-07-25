package com.zhuang.dynamic_list;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person[age=" + age + ",name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Person person=(Person) obj; 
		return this.age==person.age;
	}
	
}
