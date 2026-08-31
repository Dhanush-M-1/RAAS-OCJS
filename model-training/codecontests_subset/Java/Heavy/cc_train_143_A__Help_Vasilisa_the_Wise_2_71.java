import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	Scanner in;
	PrintWriter out;

	boolean check(int a[][]) {
		return a[0][0] == a[1][1] + a[2][2] && a[0][3] == a[1][2] + a[2][1] && a[2][0] == a[2][1] + a[2][2]
				&& a[1][0] == a[1][1] + a[1][2] && a[0][1] == a[1][1] + a[2][1] && a[0][2] == a[1][2] + a[2][2];
	}

	void solve() {
		int[][] a = new int[4][4];
		a[1][0] = in.nextInt();
		a[2][0] = in.nextInt();
		a[0][1] = in.nextInt();
		a[0][2] = in.nextInt();
		a[0][0] = in.nextInt();
		a[0][3] = in.nextInt();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					for (int g = 1; g <= 9; g++) {
						HashSet<Integer> m = new HashSet<Integer>();
						m.add(i);
						m.add(j);
						m.add(k);
						m.add(g);
						if (m.size() < 4) {
							continue;
						}
						a[1][1] = i;
						a[2][2] = j;
						a[2][1] = k;
						a[1][2] = g;
						if (check(a)) {
							out.println(i + " " + g);
							out.println(k + " " + j);
							return;
						}
					}
				}
			}
		}
		out.println("-1");

	}

	void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		try {
			solve();
		} finally {
			out.close();
		}
	}

}