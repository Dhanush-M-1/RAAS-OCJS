

import java.util.*;
import java.io.*;

public class Solution2 {

    private void solve() throws IOException {
        int n = in.nextInt();
        int max_time = 0;
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            if (p <= 500_000) {
                max_time = Math.max(max_time, p - 1);
            }
            else {
                max_time = Math.max(max_time, (1000_000 - p));
            }
        }
        System.out.println(max_time);
    }

    private String filename = "";
    private PrintWriter out;
    MyScanner in;

    private void run() throws IOException {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    private class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() throws IOException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(String fileTitle) throws IOException {
            this.br = new BufferedReader(new FileReader(fileTitle));
        }

        public String nextLine() throws IOException {
            String s = br.readLine();
            return s == null ? "-1" : s;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return "-1";
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public Double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

        public void close() throws IOException {
            this.br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Solution2().run();
    }
}
