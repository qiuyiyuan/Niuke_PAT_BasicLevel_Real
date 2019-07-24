package com.qiuqiu.practice.pat;

import java.util.Scanner;

/**
 * A+B和C
 * @author Administrator
 *
 */
public class PAT1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		boolean[] result= new boolean[count];
		for(int i = 0 ;i<count;i++) {
			long[] arr = new long[3];
			for(int j = 0 ;j<3;j++) {
				arr[j]=sc.nextLong();
			}
			if((arr[0]+arr[1])>arr[2]) {
				result[i]=true;
			}else {
				result[i]=false;
			}
		}
		for(int j=0;j<count;j++) {
			System.out.println("Case #"+(j+1)+": "+result[j]);
		}
	}
}
