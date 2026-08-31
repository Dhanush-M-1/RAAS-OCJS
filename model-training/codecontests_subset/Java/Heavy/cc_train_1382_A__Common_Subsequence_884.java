import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }

    private static void run() {
        int t = nextInt();
        int[] a = new int[1001];
        int[] b = new int[1001];
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            int m = nextInt();
            Arrays.fill(a, 0);
            Arrays.fill(b, 0);
            for (int j = 0; j < n; j++) {
                a[nextInt()] = 1;
            }
            for (int j = 0; j < m; j++) {
                b[nextInt()] = 1;
            }
            int ans = -1;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == 1 && b[j] == 1) {
                    ans = j;
                    break;
                }
            }
            if (ans != -1) {
                pw.println("YES");
                pw.println(1 + " " + ans);
            } else {
                pw.println("NO");
            }
        }
    }
}
