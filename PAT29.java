package com.qiuqiu.practice.pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PAT29 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sell = sc.next();
		String need = sc.next();
		sc.close();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Character[] sellCharArray = new Character[sell.length()];
		for(int i=0;i<sell.length();i++) {
			sellCharArray[i]=sell.charAt(i);
			if(map.get(sellCharArray[i])!=null) {
				int counts=map.get(sellCharArray[i]);
				counts++;
				map.put(sellCharArray[i], counts);
			}else {
				map.put(sellCharArray[i],1);
			}
		}
		/*for(Entry<Character, Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}*/
		boolean canPay=true;
		Character[] needCharArray = new Character[need.length()];
		for(int i=0;i<need.length();i++) {
			needCharArray[i]=need.charAt(i);
			if(map.get(needCharArray[i])==null) {
				canPay=false;
				map.put(needCharArray[i], -1);
			}else {
				int counts = map.get(needCharArray[i]);
				if(counts<=0) {
					canPay=false;
				}
				counts--;
				map.put(needCharArray[i], counts);
			}
		}
		int sum=0;
		if(canPay) {//足够支付
			for(Integer n:map.values()) {
				if(n>0) {
					sum+=n;
				}
			}
			System.out.println("Yes "+sum);
		}else {//不够支付
			for(Integer n:map.values()) {
				if(n<0) {
					sum+=n;
				}
			}
			System.out.println("No "+sum*-1);
		}
	}
}
