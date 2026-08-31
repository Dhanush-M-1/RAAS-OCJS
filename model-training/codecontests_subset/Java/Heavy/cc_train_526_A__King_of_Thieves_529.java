import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class MainA {
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
        int n = in.nextInt();
        // platforms * pits .
        char[] s = in.next().toCharArray();
       
        // Method: Brute force
        HashSet<Integer> platforms = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            if (s[i] == '*') platforms.add(i);
        }

        // beginning index
        for (int i = 0; i < n; ++i) {
            // length of jump
            for (int j = 1; j < 26; ++j) {
                int count = 0;
                // how many times it works
                for (int k = 0; k < 5; ++k) {
                    if (platforms.contains(i + j * k)) count++;
                    else break;
                }
                if (count >= 5) {
                    out.write("yes\n");
                    // out.write(i + " " + j + " " + count + "\n");
                    return;
                }
            }
        }
        out.write("no\n");
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
