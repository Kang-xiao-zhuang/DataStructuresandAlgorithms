package com.zhuang.rbtree.tree;

public class Node<E> {
	E element;
	Node<E> left;
	Node<E> right;
	Node<E> parent;

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

	public boolean isLeftChild() {
		return parent != null && this == parent.left;
	}

	public boolean isRightChild() {
		return parent != null && this == parent.right;
	}

	// 判断叔父节点
	public Node<E> sibling() {
		if (isLeftChild()) {
			return parent.right;
		}

		if (isRightChild()) {
			return parent.left;
		}

		return null;
	}
}
