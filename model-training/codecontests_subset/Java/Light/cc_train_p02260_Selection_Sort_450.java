import java.util.Scanner;

class Main {
	public static void trace(int N, int A[]) {
		for (int i = 0; i < N; ++i) {
			if (i > 0) System.out.print(" ");
			System.out.print(A[i]);
		}
		System.out.println();
	}

	public static int selectionSort(int N, int A[]) {
		int minj, ans = 0, tmp, j;
		for (int i = 0; i < N - 1; ++i) {
			minj = i;
			for (j = i; j < N; ++j) {
				if (A[j] < A[minj]) minj = j;
			}
			tmp = A[i];
			A[i] = A[minj];
			A[minj] = tmp;
			if (i != minj) ++ans;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), A[] = new int[N], ans;
		for (int i = 0; i < N; ++i) A[i] = sc.nextInt();
		sc.close();
		ans = selectionSort(N, A);
		trace(N, A);
		System.out.println(ans);
	}
}
