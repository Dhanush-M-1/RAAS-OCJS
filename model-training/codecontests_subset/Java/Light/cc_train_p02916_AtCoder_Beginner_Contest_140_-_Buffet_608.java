
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N - 1];
		for (int i = 0; i < A.length; i++)
			A[i] = scanner.nextInt();
		for (int i = 0; i < B.length; i++)
			B[i] = scanner.nextInt();
		for (int i = 0; i < C.length; i++)
			C[i] = scanner.nextInt();
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans += B[A[i] - 1];
			if (i + 1 < A.length && A[i + 1] - A[i] == 1)
				ans += C[A[i] - 1];
		}
		System.out.println(ans);
		scanner.close();
	}
}
