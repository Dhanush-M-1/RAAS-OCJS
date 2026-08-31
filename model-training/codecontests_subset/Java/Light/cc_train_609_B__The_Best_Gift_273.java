import java.util.Scanner;

public class test10 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = s.nextInt();
		int[] q = new int[n + 1];
		int[] b = new int[d + 1];
		for (int i = 0; i < n; i++) {
			q[i] = s.nextInt();
			b[q[i]]++;
		}
		long sum = 0;
		for (int i = 0; i <= d; i++) {
			sum += b[i] * (n - b[i]);
		}
		System.out.println(sum / 2);
	}
}
