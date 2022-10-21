package com.zhuang.binarysearchtree;

import java.util.Comparator;

import com.zhuang.binarysearchtree.file.Files;
import com.zhuang.binarysearchtree.printer.BinaryTreeInfo;
import com.zhuang.binarysearchtree.printer.BinaryTrees;

public class Test {

	public static void main(String[] args) {
		 test1();
		// test2();
		// test3();
		// test4();
	}

	public static void test1() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}

		BinaryTrees.println(bst);
	}

	public static void test2() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}

		BinaryTrees.println(bst1);

		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}
		BinaryTrees.println(bst2);
	}

	public static void test3() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 40; i++) {
			bst.add((int) (Math.random() * 100));
		}

		String str = BinaryTrees.printString(bst);
		str += "\n";
		// Files.writeToFile("F:/1.txt", str, true);

		BinaryTrees.println(bst);
	}

	public static void test4() {
		BinaryTrees.println(new BinaryTreeInfo() {

			@Override
			public Object string(Object node) {
				return node.toString() + "_";
			}

			@Override
			public Object root() {
				return "A";
			}

			@Override
			public Object right(Object node) {
				if (node.equals("A"))
					return "C";
				if (node.equals("C"))
					return "E";
				return null;
			}

			@Override
			public Object left(Object node) {
				if (node.equals("A"))
					return "B";
				if (node.equals("C"))
					return "D";
				return null;
			}
		});
	}
}
