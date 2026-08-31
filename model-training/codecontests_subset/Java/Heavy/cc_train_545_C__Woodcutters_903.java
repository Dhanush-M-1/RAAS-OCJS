import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
        if (n == 0) {
            out.println(0);
            return;
        }
        if (n == 1) {
            out.println(1);
            return;
        }

        int[] pos = new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
            h[i] = in.nextInt();
        }

        int count = 2;
        boolean[] gaps = new boolean[n - 1];
        for (int i = 1; i < n - 1; i++) {
            if (!gaps[i - 1] && pos[i] - h[i] > pos[i - 1]) {
                count++;
                continue;
            }
            if (gaps[i - 1] && pos[i] - h[i] > pos[i - 1] + h[i - 1]) {
                count++;
                continue;
            }
            if (pos[i] + h[i] < pos[i + 1]) {
                gaps[i] = true;
                count++;
            }
        }

        out.println(count);
    }
}