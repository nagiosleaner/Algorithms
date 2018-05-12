package nowcoder;

import java.util.Scanner;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] num = new int[n];
			for (int i = 0; i < num.length; i++) {
				int temp = sc.nextInt();
				num[i] = temp;
			}
			int result = solution(num);
			System.out.println(result);
		}
		sc.close();
	}

	private static int solution(int[] num) {
		int result = 0;
		for (int i = 0; i < num.length; i++) {
			result ^= num[i];
		}
		return result;
	}

}
