package com.gurnoors.dsalgo.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LuckyNumberEight {
	private static final long MOD_BY = 1000000000 + 7;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String number = in.next();
		// your code goes here
		int count = 0;
		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j <= number.length(); j++) {
				String substr = null;
				
				substr = number.substring(i, j);
				
				long num = Long.valueOf(substr).longValue();
				if (num % Long.valueOf(8).longValue() == 0) {
					count++;
				}
			}
		}
		System.out.println(count % MOD_BY);
	}
}
