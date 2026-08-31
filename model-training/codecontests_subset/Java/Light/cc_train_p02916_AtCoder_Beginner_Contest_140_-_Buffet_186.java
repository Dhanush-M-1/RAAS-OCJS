import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j, ans = 0;
		int sum = 0;
		int A[] = new int[n + 1];
		int B[] = new int[n + 1];
		int C[] = new int[n];
		for (i = 1; i <= n; i++)
			A[i] = sc.nextInt();
		for (i = 1; i <= n; i++)
			B[i] = sc.nextInt();
		for (i = 1; i <= n - 1; i++)
			C[i] = sc.nextInt();

		for (i = 1; i <= n; i++) {
			sum += B[A[i]];
			if (i > 0 && A[i] - A[i - 1] == 1) {
				sum += C[A[i - 1]];
			}
		}
		ans = sum;
		System.out.println(ans);
	}
}