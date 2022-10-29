package com.zhuang.rbtree.tree;

import java.util.Comparator;

import com.zhuang.rbtree.printer.BinaryTreeInfo;

public class RBTree<E> extends BBST<E> implements BinaryTreeInfo{
	public static final boolean RED = false;
	public static final boolean BLACK = true;

	public RBTree() {
		this(null);
	}

	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	public void afterAdd(Node<E> node) {
		Node<E> parent = node.parent;

		// 添加的是根节点 或者 上溢到达了根节点
		if (parent == null) {
			black(node);
			return;
		}

		// 如果父节点是黑色，直接返回
		if (isBlack(parent))
			return;

		// 叔父节点
		Node<E> uncle = parent.sibling();
		// 祖父节点
		Node<E> grand = red(parent.parent);
		if (isRed(uncle)) { // 叔父节点是红色【B树节点上溢】
			black(parent);
			black(uncle);
			// 把祖父节点当做是新添加的节点
			afterAdd(grand);
			return;
		}

		// 叔父节点不是红色
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL
				black(parent);
			} else { // LR
				black(node);
				rotateLeft(parent);
			}
			rotateRight(grand);
		} else { // R
			if (node.isLeftChild()) { // RL
				black(node);
				rotateRight(parent);
			} else { // RR
				black(parent);
			}
			rotateLeft(grand);
		}
	}

	@Override
	public void afterRemove(Node<E> node) {
		// TODO Auto-generated method stub
		super.afterRemove(node);
	}

	// 染色操作
	private Node<E> color(Node<E> node, boolean color) {
		if (node == null)
			return node;
		((RBNode<E>) node).color = color;
		return node;
	}

	// 染成红色
	private Node<E> red(Node<E> node) {
		return color(node, RED);
	}

	// 染成黑色
	private Node<E> black(Node<E> node) {
		return color(node, BLACK);
	}

	// 判断颜色
	private boolean colorOf(Node<E> node) {
		return node == null ? BLACK : ((RBNode<E>) node).color;
	}

	// 判断是否黑色
	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}

	// 判断是否红色
	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}

	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new RBNode<>(element, parent);
	}
}
