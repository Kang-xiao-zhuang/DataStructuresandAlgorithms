package com.zhuang.linkedlist;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayList<E> {

	/**
	 * 元素的数量
	 */
	private int size;

	/**
	 * 所有的元素
	 */
	private E[] elements;

	private static final int DEFAULT_CAPACITY = 2;
	private static final int ELEMENT_NOT_FOUND = -1;

	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: 清空所有元素
	 * @author: KangXiaoZhuang
	 * @param:
	 * @return: void
	 * @throws
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 
	 * @Title: size
	 * @Description: 元素的数量
	 * @author: KangXiaoZhuang
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 是否为空
	 * @author: KangXiaoZhuang
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @Title: contains
	 * @Description: 是否包含某个元素
	 * @author: KangXiaoZhuang
	 * @param: @param  element
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加元素到尾部
	 * @author: KangXiaoZhuang
	 * @param: @param element
	 * @return: void
	 * @throws
	 */
	public void add(E element) {
		add(size, element);
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 获取index位置的元素
	 * @author: KangXiaoZhuang
	 * @param: @param  index
	 * @param: @return 索引的值
	 * @return: int
	 * @throws IndexOutOfBoundsException
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 
	 * @Title: set
	 * @Description: 索引处赋值
	 * @author: KangXiaoZhuang
	 * @param: @param  index 索引
	 * @param: @param  element 新的值
	 * @param: @return 原来索引处的值
	 * @return: int
	 * @throws IndexOutOfBoundsException
	 */
	public E set(int index, E element) {
		rangeCheck(index);

		E old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除index位置的元素
	 * @author: KangXiaoZhuang
	 * @param: @param  index
	 * @param: @return
	 * @return: int
	 * @throws IndexOutOfBoundsException
	 */
	public E remove(int index) {
		rangeCheck(index);
		E oldelement = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		trim();
		return oldelement;
	}

	/**
	 * 
	 * @Title: trim
	 * @Description: 动态数组的缩容
	 * @author: KangXiaoZhuang
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity >> 1;
		// 容量大于一半 返回不缩
		if (size > newCapacity || oldCapacity <= DEFAULT_CAPACITY) {
			return;
		}
		
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + " 缩容为 " + newCapacity);
	}

	/**
	 * 
	 * @Title: indexOf
	 * @Description: 查看元素的索引
	 * @author: KangXiaoZhuang
	 * @param: @param  element
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 在index处插入一个元素
	 * @author: KangXiaoZhuang
	 * @param: @param index
	 * @param: @param element
	 * @return: void
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, E element) {
		// 允许等于size
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 
	 * @Title: ensureCapacity
	 * @Description: 保证要有capacity的容量
	 * @author: KangXiaoZhuang
	 * @param: @param capacity
	 * @return: void
	 * @throws
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		// 新的容量扩容为原来的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + " 扩容为 " + newCapacity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append(elements[i]);
//			if (i != size - 1) {
//			string.append(", ");
//		}
		}
		sb.append("]");
		return sb.toString();
	}

	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Person--finalize");
	}
}
