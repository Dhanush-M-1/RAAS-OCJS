import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		selectionSort(A, N);
		sc.close();
	}

	public static void selectionSort(int[] A, int N) {
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			int minj = i;
			for (int j = i; j < N; j++) {
				if (A[j] < A[minj]) {
					minj = j;
				}
			}
			int tmp = A[i];
			A[i] = A[minj];
			A[minj] = tmp;
			if (i != minj) {
				count++;
			}
		}
		for (int i = 0; i < N; i++) {
			if (i > 0) {
				System.out.print(" ");
			}
			System.out.print(A[i]);
		}
		System.out.printf("\n");
		System.out.println(count);
	}
}

