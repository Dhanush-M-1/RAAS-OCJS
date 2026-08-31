import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        init();
        n = nextInt();
        for (int i = 0; i < n; i++) {
            int l = nextInt(),
                    r = nextInt(),
                    d = nextInt();
            if (l > d) {
                out.println(d);
            } else {
                out.println(d * (r / d + 1));
            }
        }
        out.close();
    }

    static BufferedReader scan;
    static PrintWriter out;
    static StringTokenizer st;

    static void init() {
        scan = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    static void init(String name1, String name2) throws Exception {
        scan = new BufferedReader(new FileReader(name1));
        out = new PrintWriter(name2);
    }

    static void smart_init(String n1, String n2) throws Exception {
        try {
            init(n1, n2);
        } catch (Exception e) {
            init();
        }
    }

    static void smart_init(String name) throws Exception {
        smart_init(name + ".in", name + ".out");
    }

    static String next() throws Exception {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(scan.readLine());
        return st.nextToken();
    }

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    static long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    static void ret(int k) {
        out.print(k);
        out.close();
        System.exit(0);
    }
}