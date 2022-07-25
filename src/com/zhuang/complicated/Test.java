package com.zhuang.complicated;

import com.zhuang.tools.Times;
import com.zhuang.tools.Times.Task;

/**
 * 
 * @ClassName: test
 * @Description:TODO(斐波那契数列)
 * @author: KangXiaoZhuang
 * @date: 2022年7月24日 下午12:26:19
 */
public class Test {

	/*
	 * 斐波那契数列
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Times.test("fib1", new Task() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib1(30));
			}
		});
		Times.test("fib2", new Task() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib2(30));
			}
		});
	}

	/**
	 * 
	 * @Title: fib1
	 * @Description: 消耗时间
	 * @author: KangXiaoZhuang
	 * @param: @param  n
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	public static int fib1(int n) {
		if (n <= 1) {
			return n;
		}
		return fib1(n - 1) + fib1(n - 2);
	}

	/**
	 * 
	 * @Title: fib2
	 * @Description: 节省时间
	 * @author: KangXiaoZhuang
	 * @param: @param  n
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	public static int fib2(int n) {
		if (n <= 1) {
			return n;
		}
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	
	
	public static int fib3(int n) {
		if (n <= 1) {
			return n;
		}
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			second=first+second;
			first=second-first;
		}
		return second;
	}

}
