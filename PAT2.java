package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 获取输入
		String str = sc.nextLine();
		// 获取要操作的字符串数组
		String[] sarr = str.split(" ");
		int number = Integer.parseInt(sarr[0]);
		int[] arr = new int[number];
		// 得到要操作的整数数组
		for (int i = 0; i < number; i++) {
			arr[i] = Integer.parseInt(sarr[i+1]);
		}
		caculate(arr);
	}

	public static void caculate(int[] arr) {
		int index = 0;
		Integer A1 = 0, A2 = 0, A3 = 0, A5 = 0;
		String A4;
		boolean tag = true;
		int count2 = 0, count4 = 0, count5 = 0;
		double average = 0;
		while (index < arr.length) {
			switch (arr[index] % 5) {
			case 0: {
				if (arr[index] % 2 == 0) {
					A1 += arr[index];
				}
				break;
			}
			case 1: {
				if (tag) {
					A2 += arr[index];
					tag = false;
				} else {
					A2 -= arr[index];
					tag = true;
				}
				count2++;
				break;
			}
			case 2: {
				A3++;
				break;
			}
			case 3: {
				count4++;
				average = (double)(average*(count4-1)+arr[index])/(double)count4;
				break;
			}
			case 4: {
				if (arr[index] > A5) {
					A5 = arr[index];
				}
				count5++;
				break;
			}
			}
			index++;
		}
		A4 = String.format("%.1f", average);

		if (A1 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A1 + " ");
		}

		if (count2 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A2 + " ");
		}

		if (A3 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A3 + " ");
		}

		if (count4 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A4 + " ");
		}

		if (count5 == 0) {
			System.out.print("N");
		} else {
			System.out.print(A5);
		}
	}
}
