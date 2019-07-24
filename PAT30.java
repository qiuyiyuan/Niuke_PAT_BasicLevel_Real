package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT30 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		System.out.println(howManyPAT(str));
	}
	
	public static long howManyPAT(String str) {
		char[] s = str.toCharArray();
		long p=0;
		long pa=0;
		long pat=0;
		for(int i=0;i<s.length;i++) {
			if(s[i]=='P') {
				p++;
			}else if(s[i]=='A'){
				pa+=p;
			}else {
				pat+=pa;
			}
		}
		return pat%1000000007;
	}
}
