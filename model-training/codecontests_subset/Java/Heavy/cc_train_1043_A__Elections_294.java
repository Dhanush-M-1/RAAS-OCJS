

import java.util.*;
import java.io.*;

public class Solution1 {

    private void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        a[0] = in.nextInt();
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
            max = Math.max(max, a[i]);
        }
        for (int i = max; i < 10000; i++) {
            int sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum2 += i - a[j];
            }
            if (sum2 > sum) {
                System.out.println(i);
                return;
            }
        }


    }

    private MyScanner in;
    private PrintWriter out;

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

    public static void main(String[] args) throws IOException{
        Locale.setDefault(Locale.US);
        new Solution1().run();
    }
}


