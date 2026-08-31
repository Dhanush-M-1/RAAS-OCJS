import java.util.Scanner;


public class Problem268A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h = new int[n];
		int[] g = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
			g[i] = sc.nextInt();
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (h[i] == g[j]) result++;
			}
		}
		System.out.println(result);
	}
}