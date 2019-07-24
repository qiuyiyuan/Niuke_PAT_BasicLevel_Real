package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();// 第一个字符串
		String second = sc.nextLine();// 第二个字符串
		String third = sc.nextLine();// 第三个字符串
		String forth = sc.nextLine();// 第四个字符串

		// System.out.println('a'-'A');//大小写字母之间相差32
		String weekday = getWeekday(first, second);
		String hour = getHour(first, second);
		String minute = getMinute(third, forth);
		System.out.println(weekday+" "+hour+":"+minute);
	}

	public static String getWeekday(String first, String second) {
		String weekday = "";
		char[] firstCharArray = first.toCharArray();
		char[] secondCharArray = second.toCharArray();
		int count = 0;
		for (int i = 0; i < firstCharArray.length; i++) {
			if (firstCharArray[i] == secondCharArray[i]) {
				switch (firstCharArray[i] - 'A') {

				case 0: {
					weekday = "MON";
					count++;
					break;
				}

				case 1: {
					weekday = "TUE";
					count++;
					break;
				}

				case 2: {
					weekday = "WED";
					count++;
					break;
				}

				case 3: {
					weekday = "THU";
					count++;
					break;
				}

				case 4: {
					weekday = "FRI";
					count++;
					break;
				}

				case 5: {
					weekday = "SAT";
					count++;
					break;
				}

				case 6: {
					weekday = "SUN";
					count++;
					break;
				}
				}

			}
			if (count == 1) {
				break;
			}
		}
		return weekday;
	}

	public static String getHour(String first, String second) {
		String hour = "";
		char[] firstCharArray = first.toCharArray();
		char[] secondCharArray = second.toCharArray();
		int count = 0;
		for (int i = 0; i < firstCharArray.length; i++) {
			if (firstCharArray[i] == secondCharArray[i]) {
				switch (firstCharArray[i]) {

				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					if(count==0) {
						
					}else if(count==1) {
						hour = "0" + firstCharArray[i];
						count++;
					}
					break;
				}

				default: {
					if(count==1) {
						Integer temp = (firstCharArray[i] - 'A' + 10);
						hour = temp.toString();
					}
					count++;
					break;
				}

				}
				if (count == 2) {
					break;
				}
			}

		}
		return hour;
	}
	
	public static String getMinute(String third,String forth) {
		char[] thirdCharArray = third.toCharArray();
		char[] forthCharArray = forth.toCharArray();
		Integer index= new Integer(-1);
		for (int i = 0; i < thirdCharArray.length; i++) {
			if (thirdCharArray[i] == forthCharArray[i]) {
				int judge=thirdCharArray[i]-'A';
				if((judge>=0 && judge<=25)||(judge>=32 && judge<=57)) {
					index=i;
				}
				}
			if(index!=-1) {
				break;
			}
		}
		return (index>9)?index.toString():"0"+index.toString();
	}
}
