package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counts = sc.nextInt();
		char c = sc.next().charAt(0);
		sc.close();
		if(counts==0) {
			System.out.println(0);
		}else if(counts==1){
			System.out.println(c);
			System.out.println(0);
		}else {
			int i=1;
			for(;;i+=2) {
				if(counts<=countsOfMax(i)) {
					break;
				}
			}
			i-=2;//最大一行的个数
			int remain = counts-countsOfMax(i);//剩余个数
			printHourGlass(i,i,c);
			System.out.println(remain);
		}
	}
	
	public static void printHourGlass(int n,int max,char c) {
		for(int i=0;i<(max-n)/2;i++) {
			System.out.print(" ");
		}
		if(n==1) {
			System.out.print(c);
			System.out.println();
		}else {
			for(int i=0;i<n;i++) {
				System.out.print(c);
			}
			System.out.println();
			printHourGlass(n-2, max, c);
			for(int i=0;i<(max-n)/2;i++) {
				System.out.print(" ");
			}
			for(int i=0;i<n;i++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static int countsOfMax(int max) {
		if(max==1) {
			return 1;
		}else {
			return max*2+countsOfMax(max-2);
		}
	}
}
