package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT11 {
	public static void main(String[] args) {
		int[] counts = new int[10];
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		char[] numbers = n.toCharArray();
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i] - '0') {
			case 0: {
				counts[0]++;
				break;
			}
			case 1: {
				counts[1]++;
				break;
			}
			case 2: {
				counts[2]++;
				break;
			}
			case 3: {
				counts[3]++;
				break;
			}
			case 4: {
				counts[4]++;
				break;
			}
			case 5: {
				counts[5]++;
				break;
			}
			case 6: {
				counts[6]++;
				break;
			}
			case 7: {
				counts[7]++;
				break;
			}
			case 8: {
				counts[8]++;
				break;
			}
			case 9: {
				counts[9]++;
				break;
			}
			}
		}
		for(int i=0;i<10;i++) {
			if(counts[i]!=0) {
				System.out.println(i+":"+counts[i]);
			}
		}
	}
}
