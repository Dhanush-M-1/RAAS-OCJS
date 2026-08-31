import java.io.*;
import java.util.*;
import java.util.List;

public class C {
    private static StringTokenizer st;
    private static BufferedReader br;
    public static long MOD = 1000000007;

    public static void print(Object x) {
        System.out.println(x + "");
    }
    public static String join(List<?> x, String space) {
        StringBuilder sb = new StringBuilder();
        for (Object elt : x) {
            sb.append(elt);
            sb.append(space);
        }
        return sb.toString();
    }

    public static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            st = new StringTokenizer(line.trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public static List<Integer> nextInts(int N) throws IOException {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            ret.add(nextInt() - 1);
        }
        return ret;
    }

    public static double solve(int n, int m, double[] expected, char[][] strings, int guessed) {
        if (expected[guessed] == -1) {
            for (int guess = 0; guess < m; guess++) {
                if (((guessed >> guess) & 1) == 1) continue;
                int nextGuessed = guessed | (1 << guess);
                solve(n, m, expected, strings, nextGuessed);
            }
        }
        return expected[guessed];
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = nextInt();
        int m = nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) weight[i] = nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = nextInt() - 1;
        List<Integer> bookOrder = new ArrayList<Integer>();
        for (int i = 0; i < m; i++)
            if (!bookOrder.contains(b[i]))
                bookOrder.add(b[i]);
        for (int i = 0; i < n; i++)
            if (!bookOrder.contains(i))
                bookOrder.add(i);

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; ; j++) {
                if (bookOrder.get(j) == b[i]) {
                    bookOrder.remove(j);
                    bookOrder.add(0, b[i]);
                    break;
                }
                total += weight[bookOrder.get(j)];
            }
        }
        print(total);
    }
}
