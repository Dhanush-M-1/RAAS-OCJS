import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        tok = new StringTokenizer("");
        new B().solve();
        out.flush();
        out.close();
    }

    String nextTok() throws IOException {
        if (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextTok());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextTok());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextTok());
    }

    void solve() throws IOException {
        int n = nextInt();
        int a1 = 0;
        int a2 = 0;
        Integer m[] = new Integer[n];
        Integer m1[] = new Integer[n-1];
        Integer m2[] = new Integer[n-2];
        for (int i = 0; i < n; i++) {
            m[i] = new Integer(nextInt());
        }

        for (int i = 0; i < n-1; i++) {
            m1[i] = new Integer(nextInt());
        }

        for (int i = 0; i < n-2; i++) {
            m2[i] = new Integer(nextInt());
        }

        Arrays.sort(m);
        Arrays.sort(m1);
        Arrays.sort(m2);
      
        for (int i = 0; i < n-1; i++) {
            if (!m[i].equals(m1[i])) {
                a1 = m[i];
                break;
            }
            if (m[i].equals(m1[i]) && i == n-2) {
                a1 = m[i+1];
            }
        }

        for (int i = 0; i < n-2; i++) {
            if (!m1[i].equals(m2[i])) {
                a2 = m1[i];
                break;
            }
            if (m1[i].equals(m2[i]) && i == n-3) {
                a2 = m1[i+1];
            }
        }

        System.out.println(a1);
        System.out.println(a2);
    }
}
