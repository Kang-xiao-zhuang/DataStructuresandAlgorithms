package com.zhuang.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import com.zhuang.queue.circle.CircleDeque;
import com.zhuang.queue.circle.CircleQueue;

public class Test {
    public static void main(String[] args) {
        test1();
        // test2();
        // test3();

/*		int n = 13;
		int m = 7;

		if (n >= m) {
			System.out.println(n - m);
		} else {
			System.out.println(n);
		}
		// m > 0, n >= 0, n < 2m
		System.out.println(n - (n >= m ? m : 0));

		System.out.println(n % m);*/
    }

    public static void test1() {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(2);
        System.out.println(queue);
        queue.enQueue(6);

        System.out.println(queue);
        // 出队
        System.out.println(queue.deQueue());
        // 队头
        System.out.println(queue.front());


        com.zhuang.queue.Deque<Integer> deque = new com.zhuang.queue.Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);

        System.out.println(deque);
        // 出队
        System.out.println(deque.deQueueFront());
        // 队头
        System.out.println(deque.front());
        /* 尾 44 33 11 22 头 */
        while (!queue.isEmpty()) {
            System.out.println(deque.deQueueRear());
        }
    }

    public static void test2() {
        CircleQueue<Integer> queue = new CircleQueue<Integer>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        // 15 16 17 18 19 5 6 7 8 9
        for (int i = 15; i < 20; i++) {
            queue.enQueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
        System.out.println(queue);
    }

    public static void test3() {
        CircleDeque<Integer> queue = new CircleDeque<>();
        // 头5 4 3 2 1 100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6 5 4 3 2 1 100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }

        // 头 null 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null null
        // null null 尾
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        // 头 11 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null null null
        // 12 尾
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }
}

// https://leetcode.cn/problems/implement-queue-using-stacks/
class MyQueue {

    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    // 入队
    public void push(int x) {
        inStack.push(x);
    }

    // 弹出
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    // 队头元素
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // 是否为空
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

// https://leetcode.cn/problems/implement-stack-using-queues/
class MyStack {
    java.util.Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
