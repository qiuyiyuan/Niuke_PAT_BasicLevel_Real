package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StandardPAT10 implements Comparable<StandardPAT10>{
	double stock,total;//库存与总售价
	double unit;//单价
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D = sc.nextInt();
		double sum=0;
		ArrayList<StandardPAT10> mooncakes = new ArrayList<StandardPAT10>();
		for(int i=0;i<N;i++) {
			StandardPAT10 p = new StandardPAT10(sc.nextDouble());
			mooncakes.add(p);
		}
		for(int i=0;i<N;i++) {
			mooncakes.get(i).setTotal(sc.nextDouble());
		}
		Collections.sort(mooncakes);
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
		System.out.println(String.format("%1$.2f", sum));
	}
	
	StandardPAT10(double stock) {
		this.stock=stock;
	}
	
	void setTotal(double total) {
		this.total=total;
		this.unit=this.total/this.stock;
	}
	
	@Override
	public int compareTo(StandardPAT10 c) {
		if(this.unit>c.unit) {
			return -1;
		}else if(this.unit<c.unit) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return this.stock+" "+this.total+" "+this.unit;
	}
}
