package com.gurnoors.dsalgo.hackerrank;

import java.util.EmptyStackException;
import java.util.Stack;

public class BracketValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// inp
		/*
		 * arr = [ "()", "[{}]" ]
		 * 
		 * op = [ "YES", "NO" ]
		 */
		String[] arr = { "()", "[{}]", "{{}", "{}}" };
		String ops[] = validate(arr);
		for (String op : ops) {
			System.out.println(op);
		}
	}

	private static String[] validate(String[] arr) {
		String[] toRet = new String[arr.length];
		
		boolean isNotOkay = false;
		int i = 0;
		for (String testCase : arr) {
			Stack<Character> roundSt = new Stack<>();
			char[] braces = testCase.toCharArray();
			for (char brace : braces) {
				switch (brace) {
				case '(':
					roundSt.push(Character.valueOf(brace));
					break;
				case '{':
					roundSt.push(Character.valueOf(brace));
					break;
				case '[':
					roundSt.push(Character.valueOf(brace));
					break;
	
				case ')':
					try {
						Character popped = roundSt.pop();
						if(popped == '('){
							break;
						}else{
							isNotOkay = true;
						}
					} catch (EmptyStackException e) {
						isNotOkay = true;
						break;
					}
					break;
					
				case '}':
					
					try {
						Character popped = roundSt.pop();
						if(popped == '{'){
							break;
						}else{
							isNotOkay = true;
						}
					} catch (EmptyStackException e) {
						isNotOkay = true;
						break;
					}

					break;
				case ']':
					try {
						Character popped = roundSt.pop();
						if(popped == '['){
							break;
						}else{
							isNotOkay = true;
						}
					} catch (EmptyStackException e) {
						isNotOkay = true;
						break;
					}
					break;
				
				default:
					System.out.println("Unknown case: " + String.valueOf(brace));
				}
			}
			if (isNotOkay) {
				isNotOkay = false;
				toRet[i] = "NO";
			} else {
				if (roundSt.isEmpty()) {
					toRet[i] = "YES";
				} else {
					toRet[i] = "NO";
				}
			}
			i++;
		}

		return toRet;
	}

}
