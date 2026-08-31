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
 * @author Artyom Korzun
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        char[] a = in.nextWord();
        char[] b = in.nextWord();
        char[] c = in.nextWord();

        int[] aChars = Arrays.computeChars(a, 'a', 'z');
        int[] bChars = Arrays.computeChars(b, 'a', 'z');
        int[] cChars = Arrays.computeChars(c, 'a', 'z');

        int maxBCount = computeCount(aChars, bChars);
        int bCount = 0;
        int cCount = 0;
        for (int i = 0, max = 0; i <= maxBCount; i++) {
            int[] curBChars = multiply(i, bChars);
            int[] remainingChars = substract(aChars, curBChars);
            int j = computeCount(remainingChars, cChars);
            if (i + j > max) {
                max = i + j;
                bCount = i;
                cCount = j;
            }
        }

        int i = 0;
        for (int j = 0; j < bCount; j++) {
            for (int k = 0; k < b.length; k++) {
                a[i++] = b[k];
            }
        }

        for (int j = 0; j < cCount; j++) {
            for (int k = 0; k < c.length; k++) {
                a[i++] = c[k];
            }
        }

        aChars = substract(aChars, multiply(bCount, bChars));
        aChars = substract(aChars, multiply(cCount, cChars));

        for (int j = 0; j < 26; j++) {
            for (; aChars[j] > 0; aChars[j]--) {
                a[i++] = (char) ('a' + j);
            }
        }

        out.print(a);
    }

    private int computeCount(int[] chars, int charsB[]) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (charsB[i] > 0)
                count = Math.min(count, chars[i] / charsB[i]);
        }

        return count;
    }

    private int[] multiply(int number, int[] chars) {
        int[] result = new int[26];
        for (int i = 0; i < chars.length; i++)
            result[i] = chars[i] * number;

        return result;
    }

    private int[] substract(int[] chars, int[] charsB) {
        int[] result = new int[26];
        for (int i = 0; i < chars.length; i++)
            result[i] = chars[i] - charsB[i];

        return result;
    }
}

class FastScanner {

    private final BufferedReader reader;

    private StringTokenizer tokenizer;

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public char[] nextWord(){
        return next().toCharArray();
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());

        return tokenizer.nextToken();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class Arrays {

    public static int[] computeChars(char[] array, char from, char to) {
        int length = to - from + 1;
        int[] chars = new int[length];
        for (char c : array) {
            int i = c - from;
            if(i < 0 || i >= length)
                throw new IllegalArgumentException("Character \"" + c + "\" is out of range from " + from + " to " + to);

            chars[i]++;
        }

        return chars;
    }

}

