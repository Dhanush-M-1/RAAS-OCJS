import java.util.List;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author marim
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[n];
        int[] seq = new int[m];
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }

        List<Integer> t = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            seq[i] = in.nextInt() - 1;

            if (v[seq[i]] == false) {
                v[seq[i]] = true;
                t.add(seq[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (v[i] == false) {
                t.add(i);
            }
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            boolean ok = false;

            for (int j = t.size() - 1; j >= 0; j--) {
                if (t.get(j) == seq[i]) {
                    ok = true;
                } else if (ok) {
                    sum += w[t.get(j)];
                    t.set(j + 1, t.get(j));
                }
            }
            t.set(0, seq[i]);
        }

        out.println(sum);
    }
}

