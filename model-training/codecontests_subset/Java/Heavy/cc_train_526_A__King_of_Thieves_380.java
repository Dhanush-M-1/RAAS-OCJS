import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by timur on 28.03.15.
 */

public class TaskA {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new TaskA().run();
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
        /*String name = "refrain";
        try {
            File f = new File(name + ".in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream(name + ".out");
            }
        } catch (Throwable e) {
        }*/
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    void solve() {
        int n = nextInt();
        String s = nextToken();
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i + j * 4 < n) {
                    if (s.charAt(i) == '*') {
                        if (s.charAt(i + j) == '*') {
                            if (s.charAt(i + j + j) == '*') {
                                if (s.charAt(i + j+ j + j) == '*') {
                                    if (s.charAt(i + j + j + j + j) == '*') {
                                        ok = true;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        if (ok) {
            out.print("yes");
        } else {
            out.print("no");
        }
    }
}
