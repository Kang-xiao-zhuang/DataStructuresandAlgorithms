package com.zhuang.rbtree.tree;

public class RBNode<E> extends Node<E> {
	boolean color = RBTree.RED;

	public RBNode(E element, Node<E> parent) {
		super(element, parent);
	}

	@Override
	public String toString() {
		String str = "";
		if (color == RBTree.RED) {
			str = "R_";
		}
		return str + element.toString();
	}
}
