package com.qiuqiu.practice.pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PAT22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//参赛人数
		//存储所有参赛者的信息（包括学校编号与成绩）
		Map<Integer,Integer> players = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++) {
			int schoolId=sc.nextInt();
			int score=sc.nextInt();
			if(players.get(Integer.valueOf(schoolId))!=null) {
				players.put(schoolId, players.get(Integer.valueOf(schoolId))+score);
			}else {
				players.put(schoolId, score);
			}
		}
		sc.close();
		int winnerId=0;
		int max=0;
		for(Integer i:players.keySet()) {
			if(players.get(i)>max) {
				winnerId=i;
				max=players.get(i);
			}
		}
		System.out.println(winnerId+" "+max);
	}
}
