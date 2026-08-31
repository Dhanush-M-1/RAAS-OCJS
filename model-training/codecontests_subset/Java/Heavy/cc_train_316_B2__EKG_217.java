import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class G {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    void init() {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    String readString() {
        try {
            while (tok == null || !tok.hasMoreTokens()) {
                tok = new StringTokenizer(in.readLine());
            }
            return tok.nextToken();
        } catch (Exception e) {
            return null;
        }
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    int[] readIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
        }
        return a;
    }

    public static void main(String[] args) {
        new G().run();
    }

    void run() {
        try {
            long tStart = System.currentTimeMillis();
            init();
            solve();
            in.close();
            out.close();
            long tEnd = System.currentTimeMillis();

            System.err.println(tEnd - tStart);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    void solve() {
        int n = readInt();
        int x = readInt() - 1;

        int[] a = readIntArray(n);
        for (int i = 0; i < n; i++) a[i]--;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n; i++) {
            if (a[i] == -1) continue;
            next[a[i]] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int resX = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) continue;
            boolean haveX = false;
            int cur = i;
            int len = 0;
            while (true) {
                len++;
                if (cur == x) {
                    resX = len;
                    haveX = true;
                }
                cur = next[cur];
                if (cur == -1) break;
            }
            if (!haveX) {
                list.add(len);
            }
        }

        boolean[] dp = new boolean[n + 100];
        dp[0] = true;
        for (int w : list) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i]) {
                    dp[i + w] = true;
                }
            }
        }
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                ans.add(i + resX);
            }
        }
        for (int i :ans ) {
            out.println(i);
        }

    }
}