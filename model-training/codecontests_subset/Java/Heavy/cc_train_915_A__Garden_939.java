import java.io.*;
import java.util.*;

public class Main {
    void solve(FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int min = Integer.MAX_VALUE;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (k % a[i] == 0 && k / a[i] < min)
                min = k / a[i];
        }
        System.out.println(min);

    }

    public static void main(String[] args) throws IOException {
//        FastScanner in = new FastScanner(new FileReader("input.txt"));
//        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().solve(in, out);
    }

    static class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        public FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public FastScanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) { }
            return st.nextToken();
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public boolean hasNext() {
            return st.hasMoreElements();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }
    }
}