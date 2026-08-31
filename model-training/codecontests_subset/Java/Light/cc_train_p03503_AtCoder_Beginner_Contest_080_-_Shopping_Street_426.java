import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			int[] F = new int[N];
			for (int i = 0; i < N; i++) {
				int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int value = 0;
				for (int j = 0; j < 10; j++) {
					value |= array[j] << j;
				}
				F[i] = value;
			}

			int[][] P = new int[N][11];

			for (int i = 0; i < N; i++) {
				P[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int max = Integer.MIN_VALUE;

			for (int mask = 1; mask <= 0b1111111111; mask++) {
				int value = 0;
				for (int i = 0; i < N; i++) {
					int order = mask & F[i];
					value += P[i][Integer.bitCount(order)];
				}
				max = Math.max(max, value);
			}
			System.out.println(max);
		}
	}
}
