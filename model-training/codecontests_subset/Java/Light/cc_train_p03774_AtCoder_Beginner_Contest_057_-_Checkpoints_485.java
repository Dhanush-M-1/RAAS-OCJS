import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			int[] c = new int[m], d = new int[m];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			IntStream.range(0, m).forEach(i -> {
				c[i] = scanner.nextInt();
				d[i] = scanner.nextInt();
			});
			IntStream.range(0, n).map(i -> {
				int min = Integer.MAX_VALUE;
				int minIndex = -1;
				for (int j = 0; j < m; j++) {
					int distance = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
					if (distance < min) {
						min = distance;
						minIndex = j;
					}
				}
				return minIndex + 1;
			}).forEach(System.out::println);
		}
	}
}
