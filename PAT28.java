package com.qiuqiu.practice.pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PAT28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> results = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			Integer result = sc.nextInt();
			if(results.get(result)!=null) {
				int counts = results.get(result);
				counts++;
				results.put(result, counts);
			}else {
				results.put(result,1);
			}
		}
		int k = sc.nextInt();
		Integer[] search = new Integer[k];
		for(int i=0;i<k;i++) {
			search[i] = sc.nextInt();
		}
		sc.close();
		for(int i=0;i<k-1;i++) {
			if(results.get(search[i])!=null) {
				System.out.print(results.get(search[i])+" ");
			}else {
				System.out.print("0 ");
			}
		}
		if(results.get(search[k-1])!=null) {
			System.out.print(results.get(search[k-1]));
		}else {
			System.out.print(0);
		}
	}
}
