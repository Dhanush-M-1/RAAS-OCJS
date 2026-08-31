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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        char[] c = in.next().toCharArray();
        int[] lettersInA = new int[26];
        int[] lettersInB = new int[26];
        int[] lettersInC = new int[26];
        for (int i = 0; i < a.length; i++) {
            lettersInA[a[i] - 'a']++;
        }
        for (int i = 0; i < b.length; i++) {
            lettersInB[b[i] - 'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            lettersInC[c[i] - 'a']++;
        }
        int max = 0;
        int maxBCanBuild = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (lettersInB[i] == 0)
                continue;
            maxBCanBuild = Math.min(maxBCanBuild, lettersInA[i] / lettersInB[i]);
        }
        if (maxBCanBuild == Integer.MAX_VALUE) {
            maxBCanBuild = 0;
        }
        int maxCCanBuild = 0;
        int B = 0;
        int C = 0;
        for (int i = 0; i <= maxBCanBuild; i++) {
            int[] let = Arrays.copyOf(lettersInA, 26);
            for (int j = 0; j < 26; j++) {
                let[j] -= lettersInB[j] * i;
            }
            maxCCanBuild = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (lettersInC[j] == 0)
                    continue;
                maxCCanBuild = Math.min(maxCCanBuild, let[j] / lettersInC[j]);
            }
            if (maxCCanBuild == Integer.MAX_VALUE) {
                maxCCanBuild = 0;
            }
            if (i + maxCCanBuild > max) {
                max = i + maxCCanBuild;
                B = i;
                C = maxCCanBuild;
            }
        }
        if (max == 0) {
            out.println(a);
        } else {
            for (int i = 0; i < B; i++) {
                out.print(b);
                for (int j = 0; j < 26; j++) {
                    lettersInA[j] -= lettersInB[j];
                }
            }
            for (int i = 0; i < C; i++) {
                out.print(c);
                for (int j = 0; j < 26; j++) {
                    lettersInA[j] -= lettersInC[j];
                }
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < lettersInA[i]; j++) {
                    out.print((char) (i + 'a'));
                }
            }
            out.println();
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
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


}
