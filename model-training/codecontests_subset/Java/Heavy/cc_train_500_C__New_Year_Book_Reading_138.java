import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i + 1] = in.nextInt();
        }
        
        int[] b = new int[m + 1];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        b[m] = 0;

        int[] lift = new int[n + 1];
        Arrays.fill(lift, 0);
        for (int i = 0; i < m - 1; i++) {
            int j = i + 1;
            HashMap<Integer, Boolean> map = new HashMap<>();
            while (b[j] != b[i] && j < m) {
                if (!map.containsKey(b[j])) {
                    map.put(b[j], true);
                    lift[b[i]]++;
                }
                j++;
            }
        }

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += lift[i] * w[i];
        }
        out.println(result);
    }
}

class InputReader {
    StringTokenizer tokenizer;
    BufferedReader reader;

    public InputReader(InputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
