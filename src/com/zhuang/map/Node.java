package com.zhuang.map;

public class Node<K, V> {
	K key;
	V value;
	boolean color = TreeMap.RED;
	Node<K, V> left;
	Node<K, V> right;
	Node<K, V> parent;

	public Node(K key, V value, Node<K, V> parent) {
		this.key = key;
		this.value = value;
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

	public Node<K, V> sibling() {
		if (isLeftChild()) {
			return parent.right;
		}

		if (isRightChild()) {
			return parent.left;
		}

		return null;
	}

}
