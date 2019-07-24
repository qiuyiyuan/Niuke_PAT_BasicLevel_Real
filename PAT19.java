package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PAT19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] text = sc.next().toCharArray();//敲打的字符串
		char[] actualText = sc.next().toCharArray();//实际输出的字符串
		sc.close();
		String lowerCase = "[a-z]";//小写字母
		//String upperCase = "[A-Z]";//大写字母
		List<Character> list = new ArrayList<Character>();
		for(int i=0;i<text.length;i++) {
			//是小写字母的情况
			if(Pattern.matches(lowerCase, text[i]+"")) {
				//不包含该字母的大小写
				if(!list.contains(text[i]) && !list.contains(Character.toUpperCase(text[i]))) {
					list.add(Character.toUpperCase(text[i]));
				}
			}else {//不是小写字母
				if(!list.contains(text[i])) {
					list.add(text[i]);
				}
			}
		}
		/*System.out.println("输入的字符集：");
		for(Character c:list) {
			System.out.print(c);
		}*/
		for(int i=0;i<actualText.length;i++) {
			if(Pattern.matches(lowerCase, actualText[i]+"")) {
				list.remove(Character.valueOf(Character.toUpperCase(actualText[i])));
			}else {
				list.remove(Character.valueOf(actualText[i]));
			}
			
		}
		for(Character c:list) {
			System.out.print(c);
		}
	}
}
