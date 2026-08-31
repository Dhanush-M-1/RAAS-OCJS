import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			b[i] = sc.nextLong();
		}
		
		long[] minDist = new long[n];
		int[] asm = new int[n];
		Arrays.fill(minDist, 1000000000);
		for (int i = 1; i <= m; i++) {
			long c = sc.nextLong();
			long d = sc.nextLong();
			for (int j = 0; j < n; j++) {
				long dist = Math.abs(a[j] - c) + Math.abs(b[j] - d);
				if (dist < minDist[j]) {
					minDist[j] = dist;
					asm[j] = i;
				}
			}
		}
		
		Arrays.stream(asm).forEach(System.out::println);
	}
}
