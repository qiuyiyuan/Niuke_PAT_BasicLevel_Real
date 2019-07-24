package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		int sum=a+b;
		System.out.println(Integer.toString(sum, d));
	}
}
