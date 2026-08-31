import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		int B[] = new int[N];
		int C[] = new int[N - 1];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
			answer += B[i];
		}

		for (int i = 0; i < N - 1; i++) {
			C[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {
			if (A[i - 1] + 1 == A[i]) {
				answer += C[A[i - 1] - 1];
			}
		}

		System.out.println(answer);
	}
}
