import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n-1];

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		for (int i = 0; i < n-1; i++) {
			C[i] = sc.nextInt();
		}

		int ans = 0;

		for (int a: A) {
			ans += B[a-1];
		}

		for (int i=0; i < n-1; i++) {
			if (A[i] + 1 == A[i+1]) {
				ans += C[A[i]-1];
			}
		}

		System.out.println(ans);



}}