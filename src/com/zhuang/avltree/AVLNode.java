package com.zhuang.avltree;

public class AVLNode<E> extends Node<E> {

	int height = 1;

	public AVLNode(E element, Node<E> parent) {
		super(element, parent);
	}

	public int balanceFactor() {
		int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;

		int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;

		return leftHeight - rightHeight;
	}

	public void updateHeight() {
		int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;

		int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;

		height = 1 + Math.max(leftHeight, rightHeight);
	}

	public Node<E> tallerChild() {
		int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;

		int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;

		if (leftHeight > rightHeight) {
			return left;
		}

		if (leftHeight < rightHeight) {
			return right;
		}
		return isLeftChild() ? left : right;
	}
	
	@Override
	public String toString() {
		String parentString = "null";
		if (parent != null) {
			parentString = parent.element.toString();
		}
		return element + "_p(" + parentString + ")_h(" + height + ")";
	}
}
