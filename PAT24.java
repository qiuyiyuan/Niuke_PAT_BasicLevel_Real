package com.qiuqiu.practice.pat;

import java.util.Scanner;

public class PAT24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RationalNumber a = new RationalNumber(sc.next());
		RationalNumber b = new RationalNumber(sc.next());
		sc.close();
		System.out.println(a+" + "+b+" = "+a.add(b));
		System.out.println(a+" - "+b+" = "+a.add(new RationalNumber(b.fenzi*-1, b.fenmu)));
		System.out.println(a+" * "+b+" = "+a.mul(b));
		System.out.println(a+" / "+b+" = "+a.div(b));
	}
}

class RationalNumber{
	long fenzi;
	long fenmu;
	
	public RationalNumber() {
	}
	public RationalNumber(String str) {
		String[] strArr = str.split("/");
		this.fenzi = Long.parseLong(strArr[0]);
		this.fenmu = Long.parseLong(strArr[1]);
	}
	
	public RationalNumber(long fenzi,long fenmu) {
		if(fenmu<0) {
			fenzi*=(-1);
			fenmu*=(-1);
		}
		this.fenzi=fenzi;
		this.fenmu=fenmu;
	}
	
	@Override
	public String toString() {
		if(this.fenzi==0) {//分子是0
			return "0";
		}else if(this.fenzi>0) {//分子是正整数
			long k=this.fenzi/this.fenmu;
			long f=this.fenzi%this.fenmu;
			if(f==0) {
				return k+"";
			}else {
				long tempF=f;
				long tempFenmu=this.fenmu;
				//模拟约分
				for(long i=2;i<=tempF;i++) {
					while(tempFenmu%i==0 && f%i==0) {
						tempFenmu/=i;
						f/=i;
					}
				}
				return (k==0?"":k+" ")+f+"/"+tempFenmu;
			}
		}else {//分子是负整数
			long fenzi = this.fenzi*-1;
			long k=fenzi/this.fenmu;
			long f=fenzi%this.fenmu;
			if(f==0) {
				return "(-"+k+")";
			}else {
				long tempF=f;
				long tempFenmu=this.fenmu;
				//模拟约分
				for(long i=2;i<=tempF;i++) {
					while(tempFenmu%i==0 && f%i==0) {
						tempFenmu/=i;
						f/=i;
					}
				}
				if(k==0) {
					return "(-"+f+"/"+tempFenmu+")";
				}else {
					return "(-"+k+" "+f+"/"+tempFenmu+")";
				}
			}
		}
	}
	//加法（减法可用加法代替，因为减去一个数等于加上这个数的相反数）
	public RationalNumber add(RationalNumber n) {
		if(this.fenzi==0) {//a为0
			return n;
		}
		if(n.fenzi==0) {//b为0
			return this;
		}
		//a,b均不为0
		//分母相同，无需通分
		if(this.fenmu==n.fenmu) {
			long fenzi=this.fenzi+n.fenzi;
			return new RationalNumber(fenzi,this.fenmu);
		}else {//分母不同，需要通分
			//long min =this.fenmu<n.fenmu?this.fenmu:n.fenmu;//获取较小的一个分母
			return new RationalNumber(this.fenzi*n.fenmu+n.fenzi*this.fenmu,this.fenmu*n.fenmu);
		}
	}
	//乘法
	public RationalNumber mul(RationalNumber n) {
		return new RationalNumber(this.fenzi*n.fenzi, this.fenmu*n.fenmu);
	}
	
	//除法（需要多加一个除数不为0的判断）
	public String div(RationalNumber n) {
		if(n.fenzi==0) {
			return "Inf";
		}else {
			return this.mul(new RationalNumber(n.fenmu, n.fenzi)).toString();
		}
	}
}