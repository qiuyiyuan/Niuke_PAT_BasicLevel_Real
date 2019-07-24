package com.qiuqiu.practice.pat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PAT25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 正整数的个数
		Integer[] original = new Integer[n];// 原始序列
		Integer[] middle = new Integer[n];// 中间序列
		for (int i = 0; i < n; i++) {
			original[i] = Integer.valueOf(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			middle[i] = Integer.valueOf(sc.nextInt());
		}
		sc.close();
		Integer[] originalTemp = original.clone();
		ArrayList<Integer[]> insertSortList = insertSort(original);
		boolean isInsert = false;

		for (int i = 0; i < insertSortList.size(); i++) {
			if (Arrays.equals(insertSortList.get(i), middle)) {
				isInsert = true;
				System.out.println("Insertion Sort");
				Integer[] next = insertSortList.get(i + 1);
				for (int j = 0; j < next.length - 1; j++) {
					System.out.print(next[j] + " ");
				}
				System.out.print(next[next.length - 1]);
				break;
			}
		}
		// 测试代码
		/*
		 * for(Integer[] iArr:mergeSortList) {
		 * System.out.println(Arrays.toString(iArr)); }
		 */
		// 如果是插入排序则下面代码无需执行（因为题目保证有唯一解）
		if (!isInsert) {
			ArrayList<Integer[]> mergeSortList = mergeSort3(originalTemp);
			for (int i = 0; i < mergeSortList.size(); i++) {
				if (Arrays.equals(mergeSortList.get(i), middle)) {
					System.out.println("Merge Sort");
					Integer[] next = mergeSortList.get(i + 1);
					for (int j = 0; j < next.length - 1; j++) {
						System.out.print(next[j] + " ");
					}
					System.out.print(next[next.length - 1]);
					break;
				}
			}
		}

	}

	// 插入排序
	public static ArrayList<Integer[]> insertSort(Integer[] arr) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int i = 1; i < arr.length; i++) {// 从第二个数开始扫描
			int temp = arr[i];// 本轮被扫描的数字
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (temp > arr[j]) {
					break;
				} else {
					arr[j + 1] = arr[j];
				}
			}
			arr[j + 1] = temp;
			// 这里也可以加个判断把最后一次（即排好序的序列）结果过滤掉
			// 但考虑到对题目没有影响，并且会影响效率，不加
			// Integer的clone方法已经封装好，无需实现Cloneable接口，重写clone()
			if(list.size()>0) {
				if(!Arrays.equals(list.get(list.size()-1), arr)) {
					list.add(arr.clone());
				}
			}else {
				list.add(arr.clone());
			}
		}
		return list;
	}

	// 归并排序(方式一，难以记录每一轮的结果，因为归并函数merge()内没有原数组的信息)
	public static Integer[] mergeSort(Integer[] arr) {
		int length = arr.length;
		if (length < 2) {
			return arr;
		}
		int middle = (arr.length + 1) / 2;
		// 对等分割数组
		Integer[] left = Arrays.copyOfRange(arr, 0, middle);
		Integer[] right = Arrays.copyOfRange(arr, middle, arr.length);
		return merge(mergeSort(left), mergeSort(right));
	}

	public static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] result = new Integer[left.length + right.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[index++] = left[i++];
			} else {
				result[index++] = right[j++];
			}
		}
		while (i < left.length) {
			result[index++] = left[i++];
		}
		while (j < right.length) {
			result[index++] = right[j++];
		}
		return result;
	}

	// 归并排序(方式二) 添加round记录轮次
	public static Integer[] mergeSort2(Integer[] arr, int low, int high, int round) {
		int middle = (low + high) / 2;
		if (low < high) {
			mergeSort2(arr, low, middle, round + 1);
			mergeSort2(arr, middle + 1, high, round + 1);
			merger2(arr, low, middle, high, round);
		}
		return arr;
	}

	public static void merger2(Integer[] arr, int low, int middle, int high, int round) {
		// 用于存储归并后的临时数组
		Integer[] temp = new Integer[high - low + 1];
		int index = 0;
		int i = low;
		int j = middle + 1;
		// 遍历两个数组依次取出小的数字，放入临时数组中
		while (i <= middle && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
		}
		// 处理多余的数据
		while (j <= high) {
			temp[index++] = arr[j++];
		}
		while (i <= middle) {
			temp[index++] = arr[i++];
		}
		// 把临时数组中的数据重新存入原数组中
		for (int k = 0; k < temp.length; k++) {
			arr[k + low] = temp[k];
		}
		System.out.println(round + "\t" + Arrays.toString(arr));
		// mergeSortMap.put(round, arr.clone());
	}

	// 归并排序（方式三） 第二种方式顺序是先处理左边再处理右边，也难以记录每一轮的结果
	// 方式三不使用递归
	public static ArrayList<Integer[]> mergeSort3(Integer[] arr) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		for (int i = 1; i <= arr.length; i *= 2) {
			for (int j = 0; j + i < arr.length; j += i * 2) {
				merge3(arr, j, j + i - 1, Math.min(j + i * 2 - 1, arr.length - 1));
			}
			if(result.size()>0) {
				if(!Arrays.equals(result.get(result.size()-1), arr)) {
					result.add(arr.clone());
				}
			}else {
				result.add(arr.clone());
			}
		}
		return result;
	}

	private static void merge3(Integer[] arr, int low, int middle, int high) {
		// 用于存储归并后的临时数组
		Integer[] temp = new Integer[high - low + 1];// 10
		int index = 0;
		int i = low;// 0
		int j = middle + 1;// 5
		// 遍历两个数组依次取出小的数字，放入临时数组中
		while (i <= middle && j <= high) {// i<=4 && j<=9
			if (arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
			//
		}
		// 处理多余的数据
		while (j <= high) {
			temp[index++] = arr[j++];
		}
		while (i <= middle) {
			temp[index++] = arr[i++];
		}
		// 把临时数组中的数据重新存入原数组中
		for (int k = 0; k < temp.length; k++) {
			arr[k + low] = temp[k];
		}
	}
}
