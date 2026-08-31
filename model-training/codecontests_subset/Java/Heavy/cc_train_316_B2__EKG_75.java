import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int x = readInt() - 1;
        int[] a = new int[n];
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
            if (a[i] > 0) {
             p[a[i] - 1] = i;
            }
        }
        boolean[] d = new boolean[n + 1];
        d[0] = true;
        int b = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] == 0) {
                boolean flag = true;
                int j = i;
                int l = 1;
                do {
                    if (j == x) {
                        b = l;
                        flag = false;
                    }
                    j = p[j];
                    ++l;
                } while (j != -1);
                --l;
                if (flag) {
                    for (j = n - l; j >= 0; --j) {
                        if (d[j]) d[j + l] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (d[i]) {
                println(i + b);
            }
        }

        exit();
    }

    void in(String name) throws IOException {
        if (name.equals("__std")) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(name));
        }
    }

    void out(String name) throws IOException {
        if (name.equals("__std")) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(name);
        }
    }

    void exit() {
        out.close();
        System.exit(0);
    }

    char readChar() throws IOException {
        return (char) in.read();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    long readLong() throws IOException {
        return Long.parseLong(readToken());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
    }

    String readLine() throws IOException {
        st = null;
        return in.readLine();
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.print(new Formatter(Locale.US).format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter(Locale.US).format(format, args));
    }

    void print(Object value) {
        out.print(value);
    }

    void println(Object value) {
        out.println(value);
    }

    void println() {
        out.println();
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new B().solve();
    }
}
