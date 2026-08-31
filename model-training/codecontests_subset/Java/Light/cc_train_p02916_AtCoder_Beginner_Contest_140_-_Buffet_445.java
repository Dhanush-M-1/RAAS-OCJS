import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = Integer.parseInt(sc.nextLine());
			int[] A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(r -> Integer.parseInt(r)).toArray();
			int[] B = Arrays.stream(sc.nextLine().split(" ")).mapToInt(r -> Integer.parseInt(r)).toArray();
			int[] C = Arrays.stream(sc.nextLine().split(" ")).mapToInt(r -> Integer.parseInt(r)).toArray();

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += B[A[i] - 1];
				if (i > 0 && A[i - 1] + 1 == A[i]) {
					sum += C[A[i - 1] - 1];
				}
			}
			System.out.println(sum);
		}
	}
}