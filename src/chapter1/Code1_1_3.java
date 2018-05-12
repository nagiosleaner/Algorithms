package chapter1;

import java.util.Scanner;

public class Code1_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			solution(A,B,C);
		}
		sc.close();
	}

	private static void solution(int a, int b, int c) {
		// TODO Auto-generated method stub
		if (a==b&&b==c) {
			System.out.println("equal");
		}else {
			System.out.println("not equal");
		}
	}

}
