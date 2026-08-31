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
        int[] counta = new int[26];
        int[] countb = new int[26];
        int[] countc = new int[26];
        for (int i = 0; i < a.length; i++) {
            counta[a[i] - 'a']++;
        }
        for (int i = 0; i < b.length; i++) {
            countb[b[i] - 'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            countc[c[i] - 'a']++;
        }
        int[] best = new int[2];
        int max = get(counta.clone(), countb);
        for (int i = 0; i <= max; i++) {
            int[] count = Arrays.copyOf(counta, counta.length);
            for (int j = 0; j < count.length; j++) {
                count[j] -= countb[j] * i;
            }
            int second = get(count, countc);
            if (i + second > best[0] + best[1]) {
                best[0] = i;
                best[1] = second;
            }
        }
        out.println(print(counta, countb, best[0], new String(b), countc, best[1], new String(c)));
    }

    String print(int[] a, int[] countFirst, int numberOfFirst, String first, int[] countSecond, int numberOfSecond, String second) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            a[i] -= numberOfFirst * countFirst[i];
            a[i] -= numberOfSecond * countSecond[i];
        }
        for (int i = 0; i < numberOfFirst; i++) {
            res.append(first);
        }
        for (int i = 0; i < numberOfSecond; i++) {
            res.append(second);
        }
        for (int i = 0; i < a.length; i++) {
            while (a[i] > 0) {
                res.append((char) (i + 'a'));
                a[i]--;
            }
        }
        return res.toString();
    }

    int get(int[] a, int[] count) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (count[i] == 0) continue;
            res = Math.min(res, a[i] / count[i]);
        }
        return res;
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

}
