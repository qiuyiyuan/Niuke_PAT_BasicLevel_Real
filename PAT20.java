package com.qiuqiu.practice.pat;

import java.util.Arrays;
import java.util.Scanner;

public class PAT20 {
	static long p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();//输入的正整数个数
		p=sc.nextLong();//完美参数
		//输入用来构成完美数列的所有正整数
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		int max_M=0;
		//int max_m=0;
		for(int i=arr.length-1;i>0&&(i+1)>max_M;i--) {
			int M=firstPickM(arr,i);
			if(M>max_M) {
				max_M=M;
			}
		}
		/*for(int i=0;i<list.size();i++) {
			int m=firstPickm(list, p, i);
			if(m>max_m) {
				max_m=m;
			}
		}*/
		//System.out.println(Math.max(max_M, max_m));
		System.out.println(max_M);
	}
	
	//最大值M优先算法
	public static int firstPickM(int[] arr,int maxIndex) {
		int M=arr[maxIndex];//取得list的最大值
		//从最小的数开始，找到满足完美数列条件的最小数
		int i;
		for(i=0;i<maxIndex;i++) {
			if(arr[i]*p>=M) {
				break;
			}
		}
		return maxIndex-i+1;
	}
	
	//最小值m优先算法
	/*public static int firstPickm(ArrayList<Integer> list,long p,int minIndex) {
		int m=list.get(minIndex);//取得list的最小值
		//从最小的数开始，找到满足完美数列条件的最大数
		int i;
		for(i=list.size()-1;i>minIndex;i--) {
			if(m*p>=list.get(i)) {
				break;
			}
		}
		return i-minIndex+1;
	}*/
}
