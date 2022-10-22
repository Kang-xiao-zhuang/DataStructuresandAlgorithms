package com.zhuang.binarysearchtree;

import java.util.Comparator;
import java.util.Queue;

import com.zhuang.binarysearchtree.printer.BinaryTreeInfo;
import com.zhuang.linkedlist.LinkedList;

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

	public void remove(E element) {
		remove(node(element));
	}

	public boolean contains(E element) {
		return node(element) != null;
	}

	private void remove(Node<E> node) {
		if (node == null) {
			return;
		}
		size--;
		// 度为2的节点
		if (node.hasTwoChildren()) {
			// 找到后继节点
			com.zhuang.binarysearchtree.Node<E> successor = successor(node);
			// 后继节点的值覆盖度为2的节点
			node.element = successor.element;
			// 删除后继节点
			node = successor;
		}
		// 删除node节点（node的度必然是1或者0）
		Node<E> deleteNode = node.left != null ? node.left : node.right;
		// node是度为1的节点
		if (deleteNode != null) {
			// 更改parent
			deleteNode.parent = node.parent;
			// 更改parent的left，right的指向
			if (node.parent == null) {
				// node是度为1的节点并且是根节点
				root = deleteNode;
			} else if (node == node.parent.left) {
				// 删除节点是父节点的左子节点
				node.parent.left = deleteNode;
			} else if (node == node.parent.right) {
				// 删除节点是父节点的右子节点
				node.parent.right = deleteNode;
			}
		} else if (node.parent == null) {
			// node为叶子节点并且是根节点
			root = null;
		} else if (node.parent != null) {// node是叶子节点，但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else if (node == node.parent.right) {
				node.parent.right = null;
			}
		}

	}

	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) {
				return node;
			}
			if (cmp > 0) {
				node = node.right;
			} else { // cmp < 0
				node = node.left;
			}
		}
		return null;
	}

	/**
	 * 前序遍历
	 */
	/*
	 * public void preorderTraversal() { preorderTraversal(root); }
	 * 
	 * private void preorderTraversal(Node<E> node) { if (node == null) { return; }
	 * System.out.println(node.element); preorderTraversal(node.left);
	 * preorderTraversal(node.right); }
	 * 
	 *//**
		 * 中序遍历
		 */
	/*
	 * public void inorderTraversal() { inorderTraversal(root); }
	 * 
	 * private void inorderTraversal(Node<E> node) { if (node == null) { return; }
	 * inorderTraversal(node.left); System.out.println(node.element);
	 * inorderTraversal(node.right); }
	 * 
	 *//**
		 * 后序遍历
		 */

	/*
	 * public void postorderTraversal() { postorderTraversal(root); }
	 * 
	 * private void postorderTraversal(Node<E> node) { if (node == null) { return; }
	 * postorderTraversal(node.left); postorderTraversal(node.right);
	 * System.out.println(node.element); }
	 * 
	 *//**
		 * 层序遍历
		 *//*
			 * public void levelOrderTraversal() { if (root == null) { return; }
			 * Queue<Node<E>> queue = new java.util.LinkedList<>(); queue.offer(root); while
			 * (!queue.isEmpty()) { Node<E> node = queue.poll();
			 * System.out.println(node.element); // 左子节点入队 if (node.left != null) {
			 * queue.offer(node.left); } // 右子节点入队 if (node.right != null) {
			 * queue.offer(node.right); } } }
			 */

	public void preorder(Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		preorder(root, visitor);
	}

	private void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}
		visitor.stop = visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}

	public void inorder(Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		inorder(root, visitor);
	}

	private void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}
		inorder(node.left, visitor);
		if (visitor.stop) {
			return;
		}
		visitor.stop = visitor.visit(node.element);
		inorder(node.right, visitor);
	}

	public void postorder(Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		postorder(root, visitor);
	}

	private void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		if (visitor.stop) {
			return;
		}
		visitor.stop = visitor.visit(node.element);
	}

	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) {
			return;
		}
		Queue<Node<E>> queue = new java.util.LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) {
				return;
			}
			if (node.left != null) {
				queue.offer(node.left);
			}

			if (node.right != null) {
				queue.offer(node.right);
			}
		}
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

	@SuppressWarnings("unused")
	private Node<E> predecessor(Node<E> node) {
		if (node == null) {
			return null;
		}
		// 前驱节点在左子树当中（left.right.right.right....）
		Node<E> pNode = node.left;
		if (pNode != null) {
			while (pNode.right != null) {
				pNode = pNode.right;
			}
			return pNode;
		}
		// 从父节点、祖父节点中寻找前驱节点
		// 父节点不为空 并且为父节点 的左子节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		// 循环终止条件
		// node.parent == null
		// node == node.parent.right
		return node.parent;
	}

	@SuppressWarnings("unused")
	private Node<E> successor(Node<E> node) {
		if (node == null) {
			return null;
		}
		// 前驱节点在左子树当中（right.left.left.left....）
		Node<E> pNode = node.right;
		if (pNode != null) {
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}

		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		return node.parent;
	}

	/*
	 * public boolean isComplete() { if (root == null) return false;
	 * 
	 * Queue<Node<E>> queue = new LinkedList<>(); queue.offer(root);
	 * 
	 * boolean leaf = false; while (!queue.isEmpty()) { Node<E> node = queue.poll();
	 * if (leaf && !node.isLeaf()) return false; if (node.left != null && node.right
	 * != null) { queue.offer(node.left); queue.offer(node.right); } else if
	 * (node.left == null && node.right != null) { return false; } else { //
	 * 后面遍历的节点都必须是叶子节点 leaf = true; if (node.left != null) { queue.offer(node.left);
	 * } } }
	 * 
	 * return true; }
	 */
	public boolean isComplete() {
		if (root == null) {
			return false;
		}

		Queue<Node<E>> queue = new java.util.LinkedList<>();
		queue.offer(root);
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) {
				return false;
			}
			// 左子节点不为空
			if (node.left != null) {
				queue.offer(node.left);
				// 右子节点不为空 等价于 node.left == null && node.right != null
			} else if (node.right != null) { //
				return false;
			}

			if (node.right != null) {
				queue.offer(node.right);
			} else {
				// node.left==null && node.right==null
				// node.left!=null && node.right==null
				leaf = true;
			}
		}
		return true;
	}

	public int height() {
		if (root == null) {
			return 0;
		}
		// 树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new java.util.LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			if (node.left != null) {
				queue.offer(node.left);
			}

			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}

	public int height2() {
		return height(root);
	}

	private int height(Node<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, sb, "");
		return sb.toString();
	}

	private void toString(Node<E> node, StringBuilder sb, String prefix) {
		if (node == null) {
			return;
		}
		toString(node.left, sb, prefix + "L---");
		sb.append(prefix).append(node.element).append("\n");
		toString(node.right, sb, prefix + "R---");
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

}
