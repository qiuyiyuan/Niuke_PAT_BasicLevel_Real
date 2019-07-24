package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PAT10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();//月饼种类数（不超过1000）
		int D=sc.nextInt();//市场最大需求量（不超过500）
		
		ArrayList<MoonCake> mooncakes = new ArrayList<MoonCake>();
		//初始化N种月饼的库存和总售价
		for(int i=0;i<N;i++) {
			MoonCake c = new MoonCake(sc.nextDouble());
			mooncakes.add(c);
		}
		for(int i=0;i<N;i++) {
			mooncakes.get(i).setTotal(sc.nextDouble());
		}
		//根据单价将月饼从大到小排序
		Collections.sort(mooncakes);
		//总价
		double sum=0;
		while(D!=0) {
			if(D>mooncakes.get(0).stock) {
				sum+=mooncakes.get(0).total;
				D-=mooncakes.get(0).stock;
			}else {
				sum+=mooncakes.get(0).unit*D;
				D=0;
			}
			mooncakes.remove(0);
		}
		
		System.out.println(String.format("%.2f", sum));
	}
	
	
}
class MoonCake implements Comparable<MoonCake>{
	double stock;//库存
	double total;//总售价
	double unit;//单价
	
	public MoonCake(double stock) {
		this.stock=stock;
	}
	
	public void setTotal(double total) {
		this.total=total;
		this.unit=this.total/this.stock;
	}
	
	@Override
	public int compareTo(MoonCake c) {
		if(this.unit>c.unit) {
			return -1;
		}else if(this.unit<c.unit) {
			return 1;
		}else {
			return 0;
		}
	}
}

