package com.zhuang.linkedlist;

public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;

	private static final int ELEMENT_NOT_FOUND = -1;

	private static class Node<E> {
		private E element;
		// 下一个值
		private Node<E> prev;
		private Node<E> next;

		public Node(Node<E> prev, E element, Node<E> next) {
			super();
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;

		// index=0
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
		}
		// index=size-1
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		// 往后面添加元素
		if (index == size) {
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, null);
			// 链表添加的第一个元素
			if (oldLast == null) {
				first = last;
			} else {
				oldLast.next = last;
			}
		} else {
			// 索引当前的node
			Node<E> node = node(index);
			// node之前作为prev
			Node<E> prev = node.prev;
			// 新建一个node
			Node<E> newNode = new Node<>(prev, element, node);
			// node的prev为新的node
			node.prev = newNode;
			if (prev == null) {
				first = newNode;
			} else {
				prev.next = newNode;
			}
		}
		size++;
	}

	/**
	 * 
	 * @Title: node
	 * @Description: 获取index节点位置的元素
	 * @author: KangXiaoZhuang
	 * @param: @param  index
	 * @param: @return
	 * @return: Node<E>
	 * @throws
	 */
	private Node<E> node(int index) {
		rangeCheck(index);

		// 进行判断 索引小于大小一半
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				// 索引多少 就next多少次
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				// 索引多少 就prev多少次
				node = node.prev;
			}
			return node;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append(node.element);
//			if (i != size - 1) {
//			string.append(", ");
//		}
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
