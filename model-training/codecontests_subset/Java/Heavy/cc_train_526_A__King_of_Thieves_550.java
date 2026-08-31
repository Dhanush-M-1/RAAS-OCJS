import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputStreamReader in = new InputStreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
        final Scanner scanner = new Scanner(in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String level = scanner.nextLine().trim();
        int offset = 0;

        while (offset + 4 < level.length()) {
            int jump = 1;

            while (offset + 4 * jump < level.length()) {
                if ('*' == level.charAt(offset)
                        && '*' == level.charAt(offset + 1 * jump)
                        && '*' == level.charAt(offset + 2 * jump)
                        && '*' == level.charAt(offset + 3 * jump)
                        && '*' == level.charAt(offset + 4 * jump)) {
                    out.println("yes");
                    return;
                }

                jump++;
            }

            offset++;
        }

        out.println("no");
    }
}

