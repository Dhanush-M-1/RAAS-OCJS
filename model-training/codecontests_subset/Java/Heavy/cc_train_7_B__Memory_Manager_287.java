import java.io.*;
import java.util.*;

public class B implements Runnable {

    public static void main(String[] args) {
        new Thread(new B()).start();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    boolean eof = false;

    public void run() {
        Locale.setDefault(Locale.US);
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(239);
        }
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    int a[];
    int t, m;
    int id;

    int alloc(int n) {
        aa: for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i + j] != 0)
                    continue aa;
            }
            ++id;
            for (int j = 0; j < n; j++) {
                a[i + j] = id;
            }
            return id;
        }
        return -1;
    }

    boolean erase(int n) {
        if (n == 0)
            return false;
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                a[i] = 0;
                flag = true;
            }
        }
        return flag;
    }

    void defragment() {
        int cur = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
                a[cur++] = a[i];
        }
        for (int i = cur; i < a.length; i++) {
            a[i] = 0;
        }
    }

    private void solve() throws IOException {
        t = nextInt();
        m = nextInt();
        a = new int[m];
        id = 0;
        System.err.println();
        for (int i = 0; i < t; i++) {
            String s = nextToken().toLowerCase();
            if (s.equals("alloc")) {
                int res = alloc(nextInt());
                if (res == -1) {
                    out.println("NULL");
                } else {
                    out.println(res);
                }
            } else {
                if (s.equals("erase")) {
                    if (!erase(nextInt())) {
                        out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                } else {
                    if (s.equals("defragment"))
                        defragment();
                }
            }
            System.err.println(Arrays.toString(a));
        }
    }
}