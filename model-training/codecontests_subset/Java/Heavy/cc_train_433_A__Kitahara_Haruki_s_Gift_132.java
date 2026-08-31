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

        int count100 = 0;
        int count200 = 0;

        for(int i = 0; i < n; i++) {
            int apple = in.nextInt();
            if(apple == 100) count100++;
            else count200++;
        }

        if((count100 & 1) != 0) {
            out.println("NO");
            return;
        }

        int total = count100*100 + count200 * 200;
        int target = total / 2;

        for(int i = 0; i <= count100; i++) {
            for(int j = 0; j <= count200; j++) {
                if(i * 100 + j * 200 == target) {
                    out.println("YES");
                    return;
                }
            }
        }
        out.println("NO");
    }
}

