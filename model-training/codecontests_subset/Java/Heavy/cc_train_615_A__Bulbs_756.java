import java.io.InputStreamReader;
import java.io.IOException;
import java.io.IOError;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author skt
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
        TreeSet<Integer> treeSet = new TreeSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 1; i <= m; i ++) {
            treeSet.add(i);
        }
        for (int i = 0; i < n; i ++) {
            int nm = in.nextInt();
            for (int j = 0; j < nm; j ++) {
                int button = in.nextInt();
                treeSet.remove(button);
            }
        }
        out.println(treeSet.size() == 0 ? "YES" : "NO");
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

