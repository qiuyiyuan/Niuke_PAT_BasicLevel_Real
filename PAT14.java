package com.qiuqiu.practice.pat;

import java.math.BigDecimal;
import java.util.Scanner;

public class PAT14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		BigDecimal decimal = new BigDecimal(str);
		System.out.println(decimal.toPlainString());
	}
}
