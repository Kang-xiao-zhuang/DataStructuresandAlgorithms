package com.zhuang.queue;

import com.zhuang.linkedlist.LinkedList;
import com.zhuang.linkedlist.List;

public class Deque<E> {
	private List<E> list = new LinkedList<>();

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void clear() {
		list.clear();
	}

	// 头部入队 等价于addFirst
	public void enQueueFront(E element) {
		list.add(0, element);
	}

	// 尾部入队 等价于addLast
	public void enQueueRear(E element) {
		list.add(element);
	}

	// 头部出队 等价于pollFirst
	public E deQueueFront() {
		return list.remove(0);
	}

	// 尾部出队 等价于pollLast
	public E deQueueRear() {
		return list.remove(list.size() - 1);
	}

	// 获取队头 等价于getFirst
	public E front() {
		return list.get(0);
	}

	// 获取队尾 等价于getLast
	public E rear() {
		return list.get(list.size() - 1);
	}
}
