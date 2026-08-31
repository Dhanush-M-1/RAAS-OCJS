import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Egor Zhdan
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		IOReader in = new IOReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, IOReader in, PrintWriter out) {
        String a = in.nextToken();
        String b = in.nextToken();
        String c = in.nextToken();
        int[] cntA = new int[200];
        int[] cntB = new int[200];
        int[] cntC = new int[200];
        for (int i = 0; i < a.length(); i++) {
            cntA[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            cntB[b.charAt(i)]++;
        }
        for (int i = 0; i < c.length(); i++) {
            cntC[c.charAt(i)]++;
        }

        long best = 0;
        long bx = 0;
        long by = 0;
        long[] left = new long[200];
        for (long x = 0; x <= a.length(); x++) {
            boolean ok = true;
            long maxY = Integer.MAX_VALUE;
            for (int i = 0; i < 200; i++) {
                left[i] = cntA[i] - cntB[i] * x;
                if (left[i] < 0) {
                    ok = false;
                    break;
                }

                if (cntC[i] != 0) {
                    long cur = Math.floorDiv(left[i], cntC[i]);
                    maxY = Math.min(maxY, cur);
                }
            }
            if (!ok) continue;

            if (best < x + maxY) {
                bx = x;
                by = maxY;
                best = x + maxY;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bx; i++) {
            builder.append(b);
        }
        for (int i = 0; i < by; i++) {
            builder.append(c);
        }

        for (int i = 0; i < 200; i++) {
            cntA[i] -= cntB[i] * bx + cntC[i] * by;
        }
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < cntA[i]; j++) {
                builder.append((char) i);
            }
        }
        out.println(builder);
    }
}

class IOReader {

    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public IOReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

}

