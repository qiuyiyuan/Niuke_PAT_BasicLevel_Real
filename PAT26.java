package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT26 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char c = sc.next().charAt(0);
		sc.close();
		//第一行
		for(int i=0;i<n;i++) {
			System.out.print(c);
		}
		System.out.println();
		//中间
		for(int i=0;i<(n+1)/2-2;i++) {
			System.out.print(c);
			for(int j=0;j<n-2;j++) {
				System.out.print(" ");
			}
			System.out.print(c);
			System.out.println();
		}
		//最后一行
		for(int i=0;i<n;i++) {
			System.out.print(c);
		}
	}
}
