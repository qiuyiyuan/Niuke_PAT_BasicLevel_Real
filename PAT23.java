package com.qiuqiu.practice.pat;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PAT23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] badKeys=sc.next().toCharArray();
		char[] text=sc.next().toCharArray();
		sc.close();
		for(int i=0;i<badKeys.length;i++) {
			char c =badKeys[i];
			//分三种情况：1.大写字母；2.上档键；3.其它
			if(Pattern.matches("[A-Z]", c+"")) {
				dealWithText1(text, c);
			}else if(Pattern.matches("\\+", c+"")) {
				dealWithText2(text);
			}else {
				dealWithText3(text, c);
			}
		}
		for(char c:text) {
			if(c!='~') {
				System.out.print(c);
			}
		}
	}
	
	//处理大写字母
	public static void dealWithText1(char[] text,char c) {
		char lowerCaseOfC=Character.toLowerCase(c);
		for(int i=0;i<text.length;i++) {
			if(text[i]==c || text[i]==lowerCaseOfC) {
				text[i]='~';
			}
		}
	}
	
	//处理上档键
	public static void dealWithText2(char[] text) {
		for(int i=0;i<text.length;i++) {
			if(Pattern.matches("[A-Z]", text[i]+"")) {
				text[i]='~';
			}
		}			
	}
	
	//处理其它
	public static void dealWithText3(char[] text,char c) {
		for(int i=0;i<text.length;i++) {
			if(text[i]==c) {
				text[i]='~';
			}
		}
	}
	
}
