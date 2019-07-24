package com.qiuqiu.practice.pat;

import java.util.*;
import java.text.*;

public class PAT18 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//生日个数
		DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
		Date before = df.parse("1814/09/05");
		Date after = df.parse("2014/09/07");
		Map<String,Date> map = new HashMap<String, Date>();
		//将所有有效生日放入map中
		int counts = 0;//有效数据条数
		for(int i=0;i<n;i++) {
			String name = sc.next();
			Date birthday = df.parse(sc.next());//获取Date对象
			if(birthday.after(before) && birthday.before(after)) {
				map.put(name, birthday);
				counts++;
			}
		}
		sc.close();
		System.out.print(counts+" ");
		//找出最年长的人和最年轻的人
		String oldest="";
		String youngest="";
		for(String s:map.keySet()) {
			Date d = map.get(s);
			if(d.before(after)) {
				oldest=s;
				after=d;
			}
			if(d.after(before)) {
				youngest=s;
				before=d;
			}
		}
		System.out.print(oldest+" "+youngest);
	}
}
