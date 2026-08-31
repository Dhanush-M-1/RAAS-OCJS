import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.util.Arrays;
import java.util.*;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class MainB {
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
        int n = in.nextInt(); // how many compilation errors
        HashMap<Integer, Integer> bhm = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> chm = new HashMap<Integer, Integer>();

        int[] a = new int[n];
        int[] b = new int[n-1];
        int[] c = new int[n-2];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            int x = in.nextInt();
            b[i] = x;
            if (bhm.get(x) == null) bhm.put(x, 1);
            else {
                int old = bhm.get(x);
                bhm.put(x, old + 1);
            }
        }
        for (int i = 0; i < n-2; i++) {
            int x = in.nextInt();
            c[i] = x;
            if (chm.get(x) == null) chm.put(x, 1);
            else {
                int old = chm.get(x);
                chm.put(x, old + 1);
            }
        }
        
        // Find the missing error in B -- for everything in A, see if B has it.
        for (int i = 0; i < n; i++) {
           if (bhm.get(a[i]) == null) {
                out.write(a[i] + "\n");
                break;
           }
           int old = bhm.get(a[i]);
           old--;
           bhm.put(a[i], old);
           if (old < 0) {
                out.write(a[i] + "\n");
                break;
           }

        }
        
        // Find the missing error in C -- for everything in B, see if C has it
        for (int i = 0; i < n - 1; i++) {
           if (chm.get(b[i]) == null) {
                out.write(b[i] + "\n");
                break;
           }
           int old = chm.get(b[i]);
           old--;
           chm.put(b[i], old);
           if (old < 0) {
                out.write(b[i] + "\n");
                break;
           }

        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}
