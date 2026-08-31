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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        in.nextLine();

        String s = in.nextLine();

        for (int jump = 0; jump <= n/4; jump++) {
            for (int start = 0; start < jump; start++) {
                int pos = start;
                int count = 0;
                while (pos < n) {
                    if (s.charAt(pos) == '*') count++;
                    else count = 0;
                    pos += jump;
                    if (count == 5) {
                        out.println("yes");
                        return;
                    }
                }
            }
        }

        out.println("no");
    }
}