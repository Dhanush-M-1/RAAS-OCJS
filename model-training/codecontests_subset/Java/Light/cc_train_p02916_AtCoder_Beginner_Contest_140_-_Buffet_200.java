import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N], B[] = new int[N], C[] = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		for (int i = 1; i < N; i++) {
			C[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += B[i];
		}
		for (int i = 1; i < N; i++) {
			if (A[i - 1] + 1 == A[i]) {
				ans += C[A[i-1]];
			}
		}
		sc.close();
		System.out.println(ans);
	}
}
