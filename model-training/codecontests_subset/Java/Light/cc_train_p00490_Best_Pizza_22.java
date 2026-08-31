import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] D = new int[N];
		for (int i = 0; i < N; ++i) {
			D[i] = sc.nextInt();
		}
		Arrays.sort(D);
		int max = C / A;
		int sum = 0;
		for (int i = N - 1; i >= 0; --i) {
			sum += D[i];
			max = Math.max(max, (C + sum) / (A + B * (N - i)));
		}
		System.out.println(max);
	}
}