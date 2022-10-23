package com.zhuang.avltree;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {

	public AVLTree() {
		this(null);
	}

	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	public void afterAdd(Node<E> node) {
		// 恢复平衡后的逻辑
		while ((node = node.parent) != null) {
			// node至少有parent
			// 判断是否平衡
			if (isBalanced(node)) {
				// 如果平衡 更新高度
				updateHeight(node);
			} else {
				// 不平衡 也更新高度 恢复平衡
				rebalance(node);
				// 整棵树恢复平衡
				break;
			}
		}
	}

	@Override
	public void afterRemove(Node<E> node) {
		while ((node = node.parent) != null) {
			// node至少有parent
			// 判断是否平衡
			if (isBalanced(node)) {
				// 如果平衡 更新高度
				updateHeight(node);
			} else {
				// 不平衡 也更新高度 恢复平衡
				rebalance(node);
			}
		}
	}

	@Override
	protected Node<E> createNode(E element, Node<E> parent) {

		return new AVLNode<>(element, parent);
	}

	private boolean isBalanced(Node<E> node) {

		return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
	}

	private void updateHeight(Node<E> node) {
		((AVLNode<E>) node).updateHeight();

	}

	/**
	 * 
	 * @Title: rebalance2
	 * @Description: 恢复平衡
	 * @author: KangXiaoZhuang
	 * @param: @param grand 高度最低的那个不平衡的节点
	 * @return: void
	 * @throws
	 */
	private void rebalance2(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>) grand).tallerChild();
		Node<E> node = ((AVLNode<E>) parent).tallerChild();
		// 父节点是父节点的左子树
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL
				rotateRight(grand);
			} else { // LR
				rotateLeft(parent);
				rotateRight(grand);
			}
		} else { // R
			if (node.isLeftChild()) { // RL
				rotateRight(parent);
				rotateLeft(grand);
			} else { // RR
				rotateLeft(grand);
			}
		}
	}

	/**
	 * 恢复平衡
	 * 
	 * @param grand 高度最低的那个不平衡节点
	 */
	private void rebalance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>) grand).tallerChild();
		Node<E> node = ((AVLNode<E>) parent).tallerChild();
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL
				rotate(grand, node, node.right, parent, parent.right, grand);
			} else { // LR
				rotate(grand, parent, node.left, node, node.right, grand);
			}
		} else { // R
			if (node.isLeftChild()) { // RL
				rotate(grand, grand, node.left, node, node.right, parent);
			} else { // RR
				rotate(grand, grand, parent.left, parent, node.left, node);
			}
		}
	}

	private void rotate(Node<E> r, // 子树的根节点
			Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f) {
		// 让d成为这棵子树的根节点
		d.parent = r.parent;
		if (r.isLeftChild()) {
			// 有左子节点
			r.parent.left = d;
		} else if (r.isRightChild()) {
			// 有右子节点
			r.parent.right = d;
		} else {
			// 没有父节点
			root = d;
		}
		// b-c
		b.right = c;
		if (c != null) {
			c.parent = b;
		}
		updateHeight(b);

		// e-f
		f.left = e;
		if (e != null) {
			e.parent = f;
		}
		updateHeight(f);

		// b-d-f
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
		updateHeight(d);

	}

	// 左旋转
	private void rotateLeft(Node<E> grand) {
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		grand.right = child;
		parent.left = grand;
		afterRotate(grand, parent, child);
	}

	// 右旋转
	private void rotateRight(Node<E> grand) {
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		grand.left = child;
		parent.right = grand;
		afterRotate(grand, parent, child);
	}

	private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		// 让parent称为子树的根节点
		parent.parent = grand.parent;
		if (grand.isLeftChild()) {
			grand.parent.left = parent;
		} else if (grand.isRightChild()) {
			grand.parent.right = parent;
		} else { // grand是root节点
			root = parent;
		}

		// 更新child的parent
		if (child != null) {
			child.parent = grand;
		}

		// 更新grand的parent
		grand.parent = parent;

		// 更新高度
		updateHeight(grand);
		updateHeight(parent);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
