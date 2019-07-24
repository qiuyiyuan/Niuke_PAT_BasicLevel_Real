package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int DA=sc.nextInt();
		int B=sc.nextInt();
		int DB=sc.nextInt();
		
		System.out.println(getP(A, DA)+getP(B, DB));
	}
	
	public static int getP(int N,int D) {
		int P=0;
		int muitiple=1;
		while(N>0) {
			if(N%10==D) {
				P+=muitiple*D;
				muitiple*=10;
			}
			N/=10;
		}
		return P;
	}
}
