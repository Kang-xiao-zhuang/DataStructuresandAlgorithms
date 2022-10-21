package com.zhuang.binarysearchtree;

public class Node<E> {
	 E element;
	// 左节点
	 Node<E> left;
	// 右节点
	 Node<E> right;
	// 父节点
	 Node<E> parent;

	// 构造函数
	public Node(E element, Node<E> parent) {
		this.element = element;
		this.parent = parent;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasTwoChildren() {
		return left != null && right != null;
	}

}
