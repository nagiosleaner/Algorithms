package dataStructuresInJava;

import java.util.Random;

public class Chapter1_1_1 {
	/*
	 * 选择问题，确定N个数中第k个最大值 将k个数读入一个数组中，冒泡排序，递减，再将剩下的元素逐个读入，
	 * 如果新元素小于第k个元素，忽略，否则将新元素插入正确的位置，并移除原第k个元素
	 */
	public static final Random RANDOM = new Random(47);

	public static void main(String[] args) {
		Chapter1_1_1 sc = new Chapter1_1_1();
		int[] a = sc.getRandomArray(11);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		int[] b = sc.sort(a);
		System.out.println("****************************");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		int kValue = sc.selectK(a);
		System.out.println("****************************");
		System.out.println(kValue);
	}

	private int[] getRandomArray(int length) {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = RANDOM.nextInt(length * 2);
		}
		return array;
	}

	private int selectK(int[] num) {
		int k = num.length / 2;
		System.out.println("k====" + k);
		num = sort(num);
		return num[k];
	}

	private int[] sort(int[] kArr) {
		for (int i = 1; i < kArr.length; i++) {
			for (int j = 0; j < kArr.length - i; j++) {
				if (kArr[j] > kArr[j + 1]) {
					int temp = kArr[j];
					kArr[j] = kArr[j + 1];
					kArr[j + 1] = temp;
				}
			}
		}
		return kArr;
	}

}
