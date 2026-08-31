import java.io.*;
import java.util.*;

public class Main {

	static long mod = (long) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		A: while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scn.nextInt();
			boolean f = true;
			for (int i = 0; i < (n + 1) / 2; i++) {
				if (a[i] < i)
					f = false;
			}
			for (int i = n - 1; i >= (n + 1) / 2; i--) {
				if (a[i] < n - 1 - i)
					f = false;
			}
			if (n % 2 == 0 && (n/2 >= 1) && a[n / 2] == a[n / 2 - 1] && a[n / 2] == n / 2 - 1)
				System.out.println("No");
			else
				System.out.println(f ? "Yes" : "No");
		}
	}
}