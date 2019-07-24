package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PAT5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int L=sc.nextInt();
		int H=sc.nextInt();
		
		//获取输入的数据
		Examinee[] examinees = new Examinee[N];
		ArrayList<Examinee> firstType = new ArrayList<Examinee>();
		ArrayList<Examinee> secondType = new ArrayList<Examinee>();
		ArrayList<Examinee> thirdType = new ArrayList<Examinee>();
		ArrayList<Examinee> forthType = new ArrayList<Examinee>();
		
		for(int i=0;i<N;i++) {
			examinees[i]=new Examinee(sc.nextInt(), sc.nextInt(), sc.nextInt());
			if(examinees[i].defen>=L && examinees[i].caifen>=L) {
				if(examinees[i].defen>=H && examinees[i].caifen>=H) {
					firstType.add(examinees[i]);
				}else if(examinees[i].defen>=H) {
					secondType.add(examinees[i]);
				}else if(examinees[i].defen>=examinees[i].caifen) {
					thirdType.add(examinees[i]);
				}else {
					forthType.add(examinees[i]);
				}
			}
		}
		
		Examinee[] examinees1 = new Examinee[firstType.size()];
		Examinee[] examinees2 = new Examinee[secondType.size()];
		Examinee[] examinees3 = new Examinee[thirdType.size()];
		Examinee[] examinees4 = new Examinee[forthType.size()];
		
		for(int i=0;i<firstType.size();i++) {
			examinees1[i]=firstType.get(i);
		}
		for(int i=0;i<secondType.size();i++) {
			examinees2[i]=secondType.get(i);
		}
		for(int i=0;i<thirdType.size();i++) {
			examinees3[i]=thirdType.get(i);
		}
		for(int i=0;i<forthType.size();i++) {
			examinees4[i]=forthType.get(i);
		}
		
		//按照总分从大到小排序
		Comparator<Examinee> cmp = new MyComparator();
		Arrays.sort(examinees1,cmp);
		Arrays.sort(examinees2,cmp);
		Arrays.sort(examinees3,cmp);
		Arrays.sort(examinees4,cmp);
		
		System.out.println(examinees1.length+examinees2.length+examinees3.length+examinees4.length);
		
		for(Examinee e:examinees1) {
			System.out.println(e);
		}
		for(Examinee e:examinees2) {
			System.out.println(e);
		}
		for(Examinee e:examinees3) {
			System.out.println(e);
		}
		for(Examinee e:examinees4) {
			System.out.println(e);
		}
	}
}

class Examinee{
	public int id;
	public int defen;
	public int caifen;
	
	public Examinee() {
	}
	
	public Examinee(int id, int defen, int caifen) {
		super();
		this.id = id;
		this.defen = defen;
		this.caifen = caifen;
	}

	@Override
	public String toString() {
		return this.id+" "+this.defen+" "+this.caifen;
	}
}

class MyComparator implements Comparator<Examinee>{
	@Override
	public int compare(Examinee e1, Examinee e2) {
		if((e1.defen+e1.caifen)<(e2.defen+e2.caifen)) {
			return 1;
		}else if((e1.defen+e1.caifen)>(e2.defen+e2.caifen)) {
			return -1;
		}else {
			if(e1.defen<e2.defen) {
				return 1;
			}else if(e1.defen>e2.defen) {
				return -1;
			}else {
				if(e1.id>e2.id) {
					return 1;
				}else if(e1.id<e2.id) {
					return -1;
				}else {
					return 0;
				}
			}
		}
	}
}
