package com.zhuang.stack;

import com.zhuang.linkedlist.ArrayList;
import com.zhuang.linkedlist.List;

public class Stack<E>{

	private List<E> list = new ArrayList<>();

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(E element) {
		list.add(element);
	}

	public E pop() {
		return list.remove(list.size() - 1);
	}

	public E top() {
		return list.get(list.size() - 1);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
