import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        int w[] = new int[n + 1];
        int b[] = new int[m + 1];
        int a[] = new int[n + 1];
        int a1[] = new int[n + 1];
        Arrays.fill(a, -1);
        for(int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            if(a[b[i]] == -1) {
                a[b[i]] = count++;
                a1[count] = b[i];
            }
        }

        int lift;
        int res = 0;
        for(int i = 0; i < m; i++) {
            lift = 0;
            for(int j = 1; j <= n; j++) {
                if(a1[j] != b[i]) {
                    lift += w[a1[j]];
                } else {
                    int temp = a1[j];
                    for(int q = j; q > 1; q--) {
                        a1[q] = a1[q - 1];
                    }
                    a1[1] = temp;
                    break;
                }
            }
            res += lift;
        }

        out.print(res);
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

