package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean notFound=true;
		if(isAlike(n)) {
			System.out.println(n+" - "+n+" = 0000");
		}else {
			
			System.out.println(String.format("%04d",descendingOrder(n))+" - "+String.format("%04d",ascendingOrder(n))+" = "+String.format("%04d",(descendingOrder(n)-ascendingOrder(n))));
			n=descendingOrder(n)-ascendingOrder(n);
			if(n!=6174) {
				while(notFound) {
					System.out.println(String.format("%04d",descendingOrder(n))+" - "+String.format("%04d",ascendingOrder(n))+" = "+String.format("%04d",(descendingOrder(n)-ascendingOrder(n))));
					n=descendingOrder(n)-ascendingOrder(n);
					if(n==6174) {
						notFound=false;
					}
				}
			}
			
		}
	}
	
	//判断这个四位数是否每个数位都相同
	public static boolean isAlike(int n) {
		int gewei=n%10;
		int shiwei=n/10%10;
		int baiwei=n/100%10;
		int qianwei=n/1000;
		if(gewei==shiwei && gewei==baiwei && gewei==qianwei) {
			return true;
		}else {
			return false;
		}
	}
	
	//非升序排列
	public static int descendingOrder(int n) {
		int arrayOfN[] = new int[4];
		for(int i=1,j=0;i<=1000;i*=10,j++) {
			arrayOfN[j]=n/i%10;
		}
		return descendingOrderSort(arrayOfN);
	}
	
	public static int descendingOrderSort(int[] n) {
		for(int i=0;i<n.length-1;i++) {
			for(int j=0;j<(n.length-i-1);j++) {
				if(n[j]>n[j+1]) {
					int temp = n[j];
					n[j]=n[j+1];
					n[j+1]=temp;
				}
			}
		}
		return n[3]*1000+n[2]*100+n[1]*10+n[0];
	}
	
	//非降序排列
	public static int ascendingOrder(int n) {
		int arrayOfN[] = new int[4];
		for(int i=1,j=0;i<=1000;i*=10,j++) {
			arrayOfN[j]=n/i%10;
		}
		return ascendingOrderSort(arrayOfN);
	}
	
	public static int ascendingOrderSort(int[] n) {
		for(int i=0;i<n.length-1;i++) {
			for(int j=0;j<(n.length-i-1);j++) {
				if(n[j]>n[j+1]) {
					int temp = n[j];
					n[j]=n[j+1];
					n[j+1]=temp;
				}
			}
		}
		return n[0]*1000+n[1]*100+n[2]*10+n[3];
	}
}
