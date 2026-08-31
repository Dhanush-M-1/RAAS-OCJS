import java.io.*;
import java.util.*;
public class d {
    static int maxB = 0, maxC = 0;
    public static void main(String args[]) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        String a = sc.next(), b = sc.next(), c = sc.next();
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        int[] freqC = new int[26];
        count(a, freqA);
        count(b, freqB);
        count(c, freqC);
        num(freqA, freqB, freqC);
        for (int i = 0; i < maxB; i++) {
            out.print(b);
        }
        for (int i = 0; i < maxC; i++) {
            out.print(c);
        }
        for (int i = 0; i < 26; i++) {
            freqA[i] = freqA[i] - freqB[i] * maxB - freqC[i] * maxC;
            for (int j = 0; j < freqA[i]; j++)
                out.print((char) (i + 'a'));
        }
        out.close();
    }

    public static void num(int[] freqA, int[] freqB, int[] freqC) {
        int count1 = -1;
        while (true) {
            count1++;
            for (int i = 0; i < 26; i++) {
                if (freqB[i] > 0 && count1 * freqB[i] > freqA[i]) {
                    return;
                }
            }
            int count2 = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (freqC[i] > 0) {
                    count2 = Math.min(count2, (freqA[i] - (freqB[i] * count1)) / freqC[i]);
                }
            }
            if (count1 + count2 > maxB + maxC) {
                maxB = count1;
                maxC = count2;
            }
        }
    }

    public static void count(String a, int[] freq) {
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
        }
    }

    public static void shuffle(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    public static void shuffle(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    static class InputReader {
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

        public long nextLong() {
            return Long.valueOf(next());
        }

        public double nextDouble() {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

    }
}