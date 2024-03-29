package com.zhuang.linkedlist;

public interface List<E> {

	public static final int DEFAULT_CAPACITY = 10;
	public static final int ELEMENT_NOT_FOUND = -1;

	void clear();

	int size();

	boolean isEmpty();

	boolean contains(E element);

	void add(E element);

	E get(int index);

	E set(int index, E element);

	E remove(int index);

	int indexOf(E element);

	void add(int index, E element);
}
