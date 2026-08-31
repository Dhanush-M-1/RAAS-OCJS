import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
        int a = 0;
        int b = 0;
        for(int i = 0; i < n; i++) {
            int c = in.nextInt();
            if(c == 100) {
                a++;
            } else {
                b++;
            }
        }

        if(a % 2 == 0 && b % 2 == 0) {
            out.println("YES");
        } else if(a % 2 == 0 && b % 2 == 1 && a >= 2) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}

