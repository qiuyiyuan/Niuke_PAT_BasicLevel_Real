package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PAT21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();//身份证号码个数
		ArrayList<String> strList = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			/*String id=sc.next();
			if(Pattern.matches("[0-9]{17}[0-9X]{1}",id)) {
				strList.add(id);
			}*/
			strList.add(sc.next());
		}
		//获取有效身份证号码
		/*for(String str:strList) {
			System.out.println(str);
		}*/
		sc.close();
		int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char[] mod = {'1','0','X','9','8','7','6','5','4','3','2'};
		int counts=strList.size();
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(strList);
		for(String str:strList) {
			if(Pattern.matches("[0-9]{17}[0-9X]{1}",str)) {//字符串合法
				char[] charArr=str.toCharArray();
				int sum=0;
				for(int i=0;i<charArr.length-1;i++) {
					sum+=(Integer.parseInt(charArr[i]+"")*weight[i]);
				}
				if(charArr[17]==mod[sum%11]) {//不仅合法，且符合条件
					result.remove(str);
					counts--;
				}
			}
		}
		if(counts==0) {
			System.out.println("All passed");
		}else {
			for(String str:result) {
			System.out.println(str);
		}
		}
	}
}
