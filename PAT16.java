package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		sc.close();
		int countPoints = end-start;
		double doubleTime = (double)countPoints/100.0;
		int intTime = (int)(doubleTime+0.5);
		int hour = intTime/3600;
		intTime%=3600;
		int minute = intTime/60;
		intTime%=60;
		System.out.println(String.format("%02d", hour)+":"+String.format("%02d", minute)+":"+String.format("%02d", intTime));
	}
}
