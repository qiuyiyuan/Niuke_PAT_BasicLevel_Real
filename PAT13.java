package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Scanner;

public class PAT13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] counts = new int[10];
		for(int i=0;i<10;i++) {
			counts[i]=sc.nextInt();
		}
		for(int i=0;i<10;i++) {
			int count = counts[i];
			for(int j=0;j<count;j++) {
				list.add(i);
			}
		}
		for(Integer i:list) {
			if(i!=0) {
				System.out.print(i);
				list.remove(i);
				break;
			}
		}
		for(Integer i:list) {
			System.out.print(i);
		}
	}
}
