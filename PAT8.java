package com.qiuqiu.practice.pat;

/**
 * 'B'1'C'7'J'
 */
import java.util.Scanner;

public class PAT8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		//index=0表示甲，index=1表示乙
		int[] timesOfWin=new int[2];
		int[] timesOfDefeat=new int[2];
		int[] timesOfDraw=new int[2];
		int[] chuiziOfWin=new int[2];
		int[] jiandaoOfWin=new int[2];
		int[] buOfWin=new int[2];
		char[] jia=new char[N];
		char[] yi=new char[N];
		for(int i=0;i<N;i++) {
			jia[i]=sc.next().charAt(0);
			yi[i]=sc.next().charAt(0);
		}
		for(int i=0;i<N;i++) {
			switch(jia[i]-yi[i]) {
				case 0:{//平局
					timesOfDraw[0]++;
					timesOfDraw[1]++;
					break;
				}
				case 7:{//甲'J'乙'C' 甲败乙胜
					timesOfWin[1]++;
					timesOfDefeat[0]++;
					chuiziOfWin[1]++;
					break;
				}
				case 8:{//甲'J'乙'B' 甲胜乙败
					timesOfWin[0]++;
					timesOfDefeat[1]++;
					jiandaoOfWin[0]++;
					break;
				}
				case -7:{//甲'C'乙'J' 甲胜乙败
					timesOfWin[0]++;
					timesOfDefeat[1]++;
					chuiziOfWin[0]++;
					break;
				}
				case 1:{//甲'C'乙'B' 甲败乙胜
					timesOfWin[1]++;
					timesOfDefeat[0]++;
					buOfWin[1]++;
					break;
				}
				case -8:{//甲'B'乙'J' 甲败乙胜
					timesOfWin[1]++;
					timesOfDefeat[0]++;
					jiandaoOfWin[1]++;
					break;
				}
				case -1:{//甲'B'乙'C' 甲胜乙败
					timesOfWin[0]++;
					timesOfDefeat[1]++;
					buOfWin[0]++;
					break;
				}
				
			}
		}
		System.out.println(timesOfWin[0]+" "+timesOfDraw[0]+" "+timesOfDefeat[0]);
		System.out.println(timesOfWin[1]+" "+timesOfDraw[1]+" "+timesOfDefeat[1]);
		System.out.println(maxTimesOfGestrue(jiandaoOfWin[0], chuiziOfWin[0], buOfWin[0])+" "+maxTimesOfGestrue(jiandaoOfWin[1], chuiziOfWin[1], buOfWin[1]));
	}
	
	public static char maxTimesOfGestrue(int jiandao,int chuizi,int bu) {
		int maxTimes=0;
		char gestrue=' ';
		if(jiandao>=maxTimes) {
			maxTimes=jiandao;
			gestrue='J';
		}
		if(chuizi>=maxTimes) {
			maxTimes=chuizi;
			gestrue='C';
		}
		if(bu>=maxTimes) {
			maxTimes=bu;
			gestrue='B';
		}
		return gestrue;
	}
}
