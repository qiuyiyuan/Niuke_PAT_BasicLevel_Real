package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PAT15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNodeAddress = sc.nextInt();//首节点地址
		int counts = sc.nextInt();//节点总个数（包含无效节点）
		int reverse = sc.nextInt();//翻转个数（可大于有效节点个数）
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		
		//将所有数组放入map中
		for(int i=0;i<counts;i++) {
			int address = sc.nextInt();
			int data = sc.nextInt();
			int next = sc.nextInt();
			map.put(address, new Node(address,data,next));
		}
		sc.close();
		
		//按照首地址顺序依次从map中获取节点到链表中
		List<Node> list = new ArrayList<Node>();
		while(firstNodeAddress!=-1) {
			Node temp = map.get(firstNodeAddress);
			list.add(temp);
			firstNodeAddress=temp.next;
		}
		//此时链表中已经是有序的有效节点集
		/*for(Node n:list) {
			System.out.println(n);
		}*/
		//对链表进行反转
		for(int i=reverse;i<=list.size();i+=reverse) {
			int left=i-reverse;//最左边节点的链表索引
			int right=i-1;//最右边节点的链表索引
			while(left<right) {
				Node leftNode = list.get(left);
				Node rightNode = list.get(right);
				list.set(right, leftNode);
				list.set(left, rightNode);
				left++;
				right--;
			}
		}
		//调整地址
		adjustList(list);
		for(Node n:list) {
			System.out.println(n);
		}
	}
	
	public static void adjustList(List<Node> list) {
		int i=0;
		for(;i<list.size()-1;i++) {
			list.get(i).next=list.get(i+1).address;
		}
		list.get(i).next=-1;
	}
	
	public static class Node{
		int address;
		int data;
		int next;
		public Node(int address, int data, int next) {
			super();
			this.address = address;
			this.data = data;
			this.next = next;
		}
		@Override
		public String toString() {
			String strAddress = String.format("%05d", this.address);
			String strNext = String.format("%05d", this.next);
			if(this.next!=-1) {
				return strAddress+" "+this.data+" "+strNext;
			}else {
				return strAddress+" "+this.data+" "+"-1";
			}
		}
	}
}

