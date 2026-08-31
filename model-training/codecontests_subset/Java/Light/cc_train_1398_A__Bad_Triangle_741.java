import java.util.Scanner;

public class pb1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for (int ti = 0; ti < t; ti++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = in.nextInt();
			int s1 = a[0]+a[1];
			if (s1 <= a[n-1]) {
				System.out.println("1 2 "+n);
			} else {
				System.out.println(-1);
			}
		}
		in.close();
	}
}
