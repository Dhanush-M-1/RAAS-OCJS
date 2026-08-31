import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Vadim
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
       
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') {
                a[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(a[i] == 1) {
                for (int j = 1; j*4+i < n; j++) {
                    if(a[i+j] == 1 && a[i+2*j] == 1 && a[i+3*j] == 1 && a[i+4*j] == 1) {
                        out.print("yes");
                        return;
                    }
                }
            }
        }
        out.print("no");
    }
}

class InputReader  extends BufferedReader {
    public InputReader(InputStream st) {
        super(new InputStreamReader(st));
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }


}
