package com.zhuang.linkedlist;

public abstract class AbstractList<E> implements List<E> {
	public static final int DEFAULT_CAPACITY = 10;
	public static final int ELEMENT_NOT_FOUND = -1;
	/**
	 * 元素的数量
	 */
	protected int size;

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
	 * @Title: outOfBounds   
	 * @Description: 检查索引
	 * @author: KangXiaoZhuang   
	 * @param: @param index      
	 * @return: void      
	 * @throws
	 */
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
	}
	
	/**
	 * 
	 * @Title: rangeCheck   
	 * @Description: 索引检查
	 * @author: KangXiaoZhuang   
	 * @param: @param index      
	 * @return: void      
	 * @throws
	 */
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	/**
	 * 
	 * @Title: rangeCheckForAdd   
	 * @Description: 添加指定位置的索引检查
	 * @author: KangXiaoZhuang   
	 * @param: @param index      
	 * @return: void      
	 * @throws
	 */
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
}
