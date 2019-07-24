package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A=sc.next();
		int B=sc.nextInt();
		int remain=0;
		char[] ArrayOfA = A.toCharArray();
		char[] ArrayOfResult=new char[ArrayOfA.length];
		for(int i=0;i<ArrayOfA.length;i++) {
			int bitOfA=Integer.parseInt(ArrayOfA[i]+"")+remain*10;
			int bitOfResult=bitOfA/B;
			ArrayOfResult[i]=String.valueOf(bitOfResult).charAt(0);
			remain=bitOfA%B;
		}
		if(ArrayOfResult[0]=='0') {
			for(int i=1;i<ArrayOfResult.length;i++) {
				System.out.print(ArrayOfResult[i]);
			}
		}else {
			for(int i=0;i<ArrayOfResult.length;i++) {
				System.out.print(ArrayOfResult[i]);
			}
		}
		System.out.println(" "+remain);
	}
}
