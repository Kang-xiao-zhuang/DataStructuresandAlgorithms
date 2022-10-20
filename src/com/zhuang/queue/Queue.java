package com.zhuang.queue;

import com.zhuang.linkedlist.LinkedList;
import com.zhuang.linkedlist.List;

public class Queue<E> {
	private List<E> list = new LinkedList<>();

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	// 清空
	public void clear() {
		list.clear();
	}

	// 进队列
	public void enQueue(E element) {
		list.add(element);
	}

	public E deQueue() {
		return list.remove(0);
	}

	// 获取队列头元素
	public E front() {
		return list.get(0);
	}
}
