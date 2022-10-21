package com.zhuang.binarysearchtree;

import java.util.Comparator;

import com.zhuang.binarysearchtree.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	// 根节点
	private Node<E> root;
	// 比较器接口
	private Comparator<E> comparator;

	public BinarySearchTree() {
		this(null);
	}

	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public void add(E element) {
		// 判断
		elementNotNullCheck(element);

		// 添加第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}

		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		do {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 相等
				node.element = element;
				return;
			}
		} while (node != null);

		// 看看插入到父节点的哪个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			// 插入到父节点的右子节点
			parent.right = newNode;
		} else {
			// 插入到父节点的左子节点
			parent.left = newNode;
		}
		size++;
	}

	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		// 强制转换接口 必须是可比较
		return ((Comparable<E>) e1).compareTo(e2);
	}

	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>) node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>) node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>) node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}

	/*
	 * public void remove(E element) { remove(node(element)); }
	 * 
	 * public boolean contains(E element) { return node(element) != null; }
	 */

}
