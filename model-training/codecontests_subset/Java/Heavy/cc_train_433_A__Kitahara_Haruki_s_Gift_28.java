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
 * @author Miles Stevenson
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
        int oneHundredCount = 0, twoHundredCount = 0;
        int A = 0, B = 0;
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            if (in.nextInt() == 100)
                oneHundredCount ++;
            else
                twoHundredCount += 2;

        if ((oneHundredCount+twoHundredCount*100/100) % 2 == 1) {
            out.println("NO");
            return;
        }

        int a = 0;
        while (twoHundredCount > 0) {
            if (a == 0) {
                B += 2;
                a = 1;
            }
            else {
                A += 2;
                a = 0;
            }
            twoHundredCount -= 2;
        }

        if (Math.abs(A - B) > oneHundredCount) {
            out.println("NO");
            return;
        }
        oneHundredCount -= Math.abs(A - B);
        if (oneHundredCount % 2 == 1)
            out.println("NO");
        else
            out.println("YES");
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

