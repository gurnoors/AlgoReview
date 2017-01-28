package com.gurnoors.dsalgo.hackerrank;

import java.io.*;
import java.util.*;

public class Stacks {
	private static MyStack<Integer> stack = new MyStack<Integer>();
	private static MyStack<Integer> temp = new MyStack<>();

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		// use enum instead

		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		int queriesNo = scan.nextInt();
		for (int i = 0; i < queriesNo; i++) {
			String inp = scan.next();
			switch (inp.charAt(0)) {
			case '1':
				enqueue(Integer.valueOf(inp.split(" ")[1]));
				break;
			case '2':
				dequeue();
				break;
			case '3':
				System.out.println(peek());
				break;
			default:
				System.out.println("Unknown case: " + inp);
			}
		}
	} // end main

	private static void enqueue(int toEnqueue) {
		stack.push(Integer.valueOf(toEnqueue));
	}

	private static void dequeue() {
		while (!stack.empty()) {
			temp.push(stack.pop());
		}
		temp.pop();
		while (!temp.empty()) {
			stack.push(temp.pop());
		}
	}

	private static int peek() {
		while (!stack.empty()) {
			temp.push(stack.pop());
		}
		Integer toReturn = temp.peek();
		while (!temp.empty()) {
			stack.push(temp.pop());
		}
		return toReturn.intValue();
	}

}
