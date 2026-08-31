import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainB {

    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int t = in.nextInt();
        int m = in.nextInt();
        byte[] mem = new byte[m];
        byte bl = 1;

        String[] res = new String[t];
        int resCount = 0;
        for (int i = 0; i < t; i++) {
            String s = in.next();

            if (s.equals("alloc")) {
                int n = in.nextInt();
                int r = -1;
                for (int j = 0; j < m - n + 1; j++) {
                    boolean b = true;
                    for (int k = j; k <= j + n - 1; k++) {
                        if (mem[k] != 0) {
                            b = false;
                        }
                    }
                    if (b) {
                        for (int k = j; k <= j + n - 1; k++) {
                            mem[k] = bl;
                        }
                        r = j;
                        res[resCount] = Integer.toString(bl);
                        resCount++;
                        bl++;
                        break;
                    }
                }
                if (r == -1) {
                    res[resCount] = "NULL";
                    resCount++;
                }
            }

            if (s.equals("erase")) {
                int x = in.nextInt();
                int c = 0;
                for (int j = 0; j < m; j++) {
                    if (mem[j] == x) {
                        c++;
                        mem[j] = 0;
                    }
                }
                if (c == 0 || x == 0) {
                    res[resCount] = "ILLEGAL_ERASE_ARGUMENT";
                    resCount++;
                }
            }

            if (s.equals("defragment")) {
                byte[] newMem = new byte[m];
                int j = 0;
                for (int k = 0; k < m; k++) {
                    if (mem[k] != 0) {
                        newMem[j] = mem[k];
                        j++;
                    }
                }
                mem = newMem;
            }
        }

        for (int i = 0; i < resCount; i++) {
            out.println(res[i]);
        }
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] arg) {
        new MainB().run();
    }
}
