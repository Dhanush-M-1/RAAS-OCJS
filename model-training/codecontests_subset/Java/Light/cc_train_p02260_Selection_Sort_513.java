import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	StringBuilder out;

	void run() {
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean swap = false;
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (A[j] < A[min]) {
					min = j;
					swap = true;
				}
			}
			if (swap) {
				cnt++;
			}
			int tmp = A[i];
			A[i] = A[min];
			A[min] = tmp;
		}
		for (int i = 0; i < A.length; i++) {
			System.out.print((i == 0 ? "" : " ") + A[i]);
		}
		System.out.println("\n" + cnt);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}