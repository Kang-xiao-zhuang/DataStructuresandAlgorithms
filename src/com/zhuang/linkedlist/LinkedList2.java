package com.zhuang.linkedlist;

public class LinkedList2<E> extends AbstractList<E> {
	private Node<E> first;

	// 增加虚拟头节点
	public LinkedList2() {
		first = new Node<>(null, null);
	}

	private static final int ELEMENT_NOT_FOUND = -1;

	private static class Node<E> {
		private E element;
		// 下一个值
		private Node<E> next;

		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}

	}

	@Override
	public void clear() {
		size = 0;
		first = null;
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
		Node<E> previous = index == 0 ? first : node(index - 1);
		Node<E> node = previous.next;
		previous.next = node.next;
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

		Node<E> previous = index == 0 ? first : node(index - 1);
		previous.next = new Node<>(element, previous.next);
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

		Node<E> node = first.next;
		for (int i = 0; i < index; i++) {
			// 索引多少 就next多少次
			node = node.next;
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size=").append(size).append(", [");
		Node<E> node = first.next;
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
