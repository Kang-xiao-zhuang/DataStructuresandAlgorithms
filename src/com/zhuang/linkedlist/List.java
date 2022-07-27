package com.zhuang.linkedlist;

public interface List<E> {

//	public static final int DEFAULT_CAPACITY = 10;
//	public static final int ELEMENT_NOT_FOUND = -1;

	/**
	 * 
	 * @Title: clear
	 * @Description: 清空所有元素
	 * @author: KangXiaoZhuang
	 * @param:
	 * @return: void
	 * @throws
	 */
	void clear();

	/**
	 * 
	 * @Title: size
	 * @Description: 元素的数量
	 * @author: KangXiaoZhuang
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	int size();

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 是否为空
	 * @author: KangXiaoZhuang
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	boolean isEmpty();

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
	boolean contains(E element);

	/**
	 * 
	 * @Title: add
	 * @Description: 添加元素到尾部
	 * @author: KangXiaoZhuang
	 * @param: @param element
	 * @return: void
	 * @throws
	 */
	void add(E element);

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
	E get(int index);

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
	E set(int index, E element);

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
	E remove(int index);

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
	int indexOf(E element);

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
	void add(int index, E element);
}
