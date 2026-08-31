import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by timur on 28.03.15.
 */

public class TaskB {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new TaskB().run();
    }

    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "-1";
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }


    void run() throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        try {
            File f = new File("a.in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream("a.out");
            }
        } catch (Throwable e) {
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    void solve() {
        int n = nextInt();
        long s = nextInt();
        long[] a= new long[n];
        int les = 0, big = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            if (a[i] > s) {
                big++;
            }
            if (a[i] < s) {
                les++;
            }
        }
        Arrays.sort(a);
        long ans = 0;
        ans += Math.abs(a[n / 2] - s);
        for (int i = 0; i < n / 2; i++) {
            if (a[i] > s)
                ans += Math.abs(a[i] - s);
        }
        for (int i = n / 2 + 1; i < n; i++) {
            if (a[i] < s)
                ans += Math.abs(a[i] - s);
        }
        out.print(ans);
    }
}