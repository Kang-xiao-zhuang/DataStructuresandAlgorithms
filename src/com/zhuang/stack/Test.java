package com.zhuang.stack;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(12);
		stack.push(22);
		stack.push(244);
		stack.push(256);
		stack.pop();
		Integer top = stack.top();
		System.out.println(top);
		System.out.println(stack);
	}

	// 有效的括号
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || c != stack.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValid2(String s) {
		java.util.Stack<Character> stack = new java.util.Stack<>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		for (Character c : s.toCharArray()) {
			if (!stack.isEmpty() && map.containsKey(c)) {
				if (stack.peek().equals(map.get(c))) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
