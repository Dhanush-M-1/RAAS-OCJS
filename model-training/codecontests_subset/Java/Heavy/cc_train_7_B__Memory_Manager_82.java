import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    //////////////////////////////////////////////////////
    // Solution

    int[] memo;
    int curId = 1;
    int t, m;
    
    private void solve() throws Throwable {
        t = nextInt();
        m = nextInt();
        memo = new int[m];
        for (int tc = 0; tc < t; tc++) {
            String s = nextString();
            if (s.equals("defragment")) {
                defragment();
            } else if (s.equals("alloc")) {
                alloc(nextInt());
            } else if (s.equals("erase")) {
                erase(nextInt());
            }
        }
    }

    private void erase(int id) {
        if (id < 1) {
            pw.println("ILLEGAL_ERASE_ARGUMENT");
            return;
        }
        for (int i = 0; i < m; i++) {
            if (memo[i] == id) {
                for (int j = i; j < m && memo[j] == id; j++) {
                    memo[j] = 0;
                }
                return;
            }
        }
        pw.println("ILLEGAL_ERASE_ARGUMENT");
    }

    private void alloc(int size) {
        loop: for (int i = 0; i <= m - size; ) {
            for (int j = i; j < i + size; j++) {
                if (memo[j] != 0) {
                    i = j + 1;
                    continue loop;
                }
            }
            for (int j = i; j < i + size; j++) {
                memo[j] = curId;
            }
            pw.println(curId);
            curId++;
            return;
        }
        pw.println("NULL");
    }

    private void defragment() {
        int[] memo2 = new int[m];
        for (int i = 0, j = 0; i < m; i++) {
            if (memo[i] != 0) {
                memo2[j] = memo[i];
                j++;
            }
        }
        for (int i = 0; i < m; i++) {
            memo[i] = memo2[i];
        }
    }

    //////////////////////////////////////////////////////
    // Utility functions

    private void initstreams() throws Throwable {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }

    BufferedReader in;
    PrintWriter pw;
    StringTokenizer st;

    String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextString());
    }

    long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextString());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextString());
    }

    @Override
    public void run() {
        try {
            initstreams();
            solve();
        } catch (Throwable e) {
            sError = e;
        } finally {
            if (pw != null)
                pw.close();
        }
    }

    private static Throwable sError;

    public static void main(String[] args) throws Throwable {
        Thread t = new Thread(new Solution());
        t.start();
        t.join();
        if (sError != null)
            throw sError;
    }
}
