package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end=sc.nextInt();
		int tag=1;
		for(int i=start;i<=end;i++) {
			if(i==end) {
				System.out.print(getPrimeNumberByIndex(i));
			}else {
				if(tag%10==0) {
					System.out.print(getPrimeNumberByIndex(i));
					System.out.println();
					tag=1;
				}else {
					System.out.print(getPrimeNumberByIndex(i)+" ");
					tag++;
				}
			}
		}
	}
	
	public static int getPrimeNumberByIndex(int index) {
		int n=2;
		while(index>0) {
			if(isPrimeNumber(n)) {
				index--;
			}
			if(isPrimeNumber(n) && index==0) {
				break;
			}
			n++;
		}
		return n;
	}
	
	public static boolean isPrimeNumber(int n) {
		if (n == 1) {
			return false;
		} else if (n == 2 || n == 3) {
			return true;
		} else {
			boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
			return isPrime;
		}

	}
}
