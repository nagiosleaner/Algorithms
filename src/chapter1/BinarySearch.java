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
			if (result <0 ) {
				System.out.println("Error");
			}else {
				System.out.println("Exist");
			}
		}
		sc.close();
	}
	private static int solution(int n, int m, int[] arr) {
		int low = 0;
		int high = arr.length-1;
		QuickSort(arr,low,high);
		while (low <= high) {
			int 	mid = low + ( high - low)/2;
			if 				(m<arr[mid])		high = mid-1;
			else if 	(m>arr[mid])		low = mid+1;
			else 									return mid;
		}
		return -1;
	}
	private static void QuickSort(int[] arr, int indexStart, int indexEnd) {
		// TODO Auto-generated method stub
		int pivotIndex = (indexStart+indexEnd)/2;
		//swap
		swap(arr,pivotIndex,indexEnd);
		
		int k = partition(arr,indexStart-1, indexEnd,arr[indexEnd]);
		swap(arr, k, indexEnd);
		if ((k - indexStart)>1) 
			QuickSort(arr, indexStart, k-1);
		if ((indexEnd-k)>1) 
			QuickSort(arr, k+1, indexEnd);
	}
	private static int partition(int[] arr, int left, int right, int pivot) {
		do {
			while (arr[++left] < pivot) 
				;
			while ((right!=0)&&arr[--right]>pivot) 
				;
			swap(arr, left, right);
		} while (left < right);
		swap(arr, left, right);
		return left;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
