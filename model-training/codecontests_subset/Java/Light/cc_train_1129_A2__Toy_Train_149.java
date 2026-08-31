import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


@SuppressWarnings("unchecked")
public class Solution {

	// 22:40-
	public static void main(String[] args) throws IOException, InterruptedException {
		try (PrintStream out = new PrintStream(new BufferedOutputStream(System.out))) {
			Scanner sc = new Scanner(new BufferedInputStream(System.in));

			int n = sc.nextInt();
			int m = sc.nextInt();

			ArrayList[] xs = new ArrayList[n];
			for (int i = 0; i < xs.length; i++) xs[i] = new ArrayList();

			for (int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				xs[a].add(((n + b) - a) % n);
			}

			for (ArrayList x : xs) Collections.sort(x);

			int[] c = new int[n];
			for (int i = 0; i < c.length; i++) if (!xs[i].isEmpty())
				c[i] = (xs[i].size() - 1) * n + (Integer) xs[i].get(0);

			for (int i = 0; i < n; i++) {
				int max = 0;
				for (int j = 0; j < n; j++) {
					int curCost = c[(i + j) % n];
					if (curCost > 0) {
						max = Math.max(max, j + curCost);
					}
				}
				out.print(max + " ");
			}
			out.println();

		}
	}
}
