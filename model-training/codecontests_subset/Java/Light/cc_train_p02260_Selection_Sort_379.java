import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int count = 0;

		for (int i = 0; i < N; i++) {
			int minj = i;
			for (int j = i; j < N; j++) {
				if (A[j] < A[minj]) {
					minj = j;
				}
			}
			if (i != minj) {
				count++;
			}
			int x = A[i];
			A[i] = A[minj];
			A[minj] = x;
		}
		for (int i = 0; i < N - 1; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println(A[N - 1]);
		System.out.print(count);
		System.out.printf("\n");

	}
}
