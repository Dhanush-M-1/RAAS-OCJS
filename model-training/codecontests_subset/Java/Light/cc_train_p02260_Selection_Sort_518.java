import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int sw;
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		sw = selectionSort(A, N);

		System.out.print(A[0]);
		for (int i = 1; i < N; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println("\n" + sw);
	}

	private static int selectionSort(int[] A, int N) {
		int sw = 0;
		int minj = 0;
		for (int i = 0; i < N - 1; i++) {
			minj = i;
			for (int j = i + 1; j < N; j++) {
				if (A[j] < A[minj])
					minj = j;
			}
			int temp = A[i];
			A[i] = A[minj];
			A[minj] = temp;

			if (i != minj) {
				sw++;
			}
		}
		return sw;
	}

}

