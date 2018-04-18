package chapter1;
import java.util.Scanner;

public class BinarySearch {
	//BinarySearch
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();//数字个数
			int M = sc.nextInt();//要查找的数字
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int result = solution(N,M,arr);
			System.out.println(result);
		}
		sc.close();
	}

	private static int solution(int n, int m, int[] arr) {
		QuickSort(arr,0,arr.length-1);
		int result = 0;
		int lo = 0;
		int hi = arr.length-1;
		while (lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if (m<arr[mid]) {
				hi = mid-1;
			}else if (m>arr[mid]) {
				lo = mid+1;
			}else {
				result=mid;
			}
		}
		return result;
	}

	private static void QuickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int i, j, x;
		if (low<high) {
			i=low;
			j=high;
			x=arr[0];
			while (i < j) {
				while (i < j && arr[j] > x) {
					j--;
				}
				if (i < j) {
					arr[i] = arr[j];
					i++;
				}
				while (i < j && arr[i] < x) {
					i++;
				}
				if (i < j) {
					arr[j] = arr[i];
					j--;
				}
			}
			arr[i] = x;
			QuickSort(arr, low, i-1);
			QuickSort(arr, i+1, high);
		}
	}
}
