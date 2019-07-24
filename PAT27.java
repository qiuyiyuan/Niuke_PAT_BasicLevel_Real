package com.qiuqiu.practice.pat;

import java.util.Scanner;

/**
 * 29 Knut = 1 Sickle
 * 17 Sickle = 1 Galleon
 * @author Administrator
 *
 */
public class PAT27 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] price = sc.next().split("\\.");
		String[] pay = sc.next().split("\\.");
		sc.close();
		int[] galleon = new int[3];
		galleon[0]=Integer.parseInt(price[0]);
		galleon[1]=Integer.parseInt(pay[0]);
		int[] sickle = new int[3];
		sickle[0]=Integer.parseInt(price[1]);
		sickle[1]=Integer.parseInt(pay[1]);
		int[] knut = new int[3];
		knut[0]=Integer.parseInt(price[2]);
		knut[1]=Integer.parseInt(pay[2]);
		//判断是否足够支付
		boolean enough=false;
		if(galleon[1]-galleon[0]>0) {
			enough=true;
		}else if(galleon[1]==galleon[0]){
			if(sickle[1]-sickle[0]>0) {
				enough=true;
			}else if(sickle[1]==sickle[0]) {
				if(knut[1]>=knut[0]) {
					enough=true;
				}
			}
		}
		//获取价格和实付款完毕，开始计算
		//模拟借位
		if(enough) {
			if(knut[1]<knut[0]) {
				sickle[1]--;
				knut[1]+=29;
			}
			knut[2]=knut[1]-knut[0];
			if(sickle[1]<sickle[0]) {
				galleon[1]--;
				sickle[1]+=17;
			}
			sickle[2]=sickle[1]-sickle[0];
			galleon[2]=galleon[1]-galleon[0];
			System.out.println(galleon[2]+"."+sickle[2]+"."+knut[2]);
		}else {//不够支付
			if(knut[0]<knut[1]) {
				sickle[0]--;
				knut[0]+=29;
			}
			knut[2]=knut[0]-knut[1];
			if(sickle[0]<sickle[1]) {
				galleon[0]--;
				sickle[0]+=17;
			}
			sickle[2]=sickle[0]-sickle[1];
			galleon[2]=galleon[0]-galleon[1];
			System.out.println("-"+galleon[2]+"."+sickle[2]+"."+knut[2]);
		}
		
	}
}
