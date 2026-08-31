

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 入力の受け取り
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// 解法
		// Selection sort, cntは交換回数
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			int minID = i;
			for (int j = i; j < N; j++) {
				if (A[minID] > A[j]) {
					minID = j;
				}
			}
			if (minID != i) {
				cnt++;
				int w = A[i];
				A[i] = A[minID];
				A[minID] = w;
			}
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + (i != A.length - 1 ? " " : "\n"));
		}
		System.out.println(cnt);

		// 入力の開放
		sc.close();
	}
}

