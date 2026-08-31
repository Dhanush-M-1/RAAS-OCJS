import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.*;

public class Solve3 {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        new Solve3().solve(pw);
        pw.flush();
        pw.close();
    }

    public void solve(PrintWriter pw) {
        FastReader sc = new FastReader();
        long x = sc.nextLong();
        if (x == 1 || isPrime(x)) {
            pw.println(1);
            pw.println(0);
            return;
        }
        ArrayList<Long> div = new ArrayList();
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                div.add( i);
                if (i * i != x) div.add(x / i);
            }
        }
        Collections.sort(div);
        for (int i = 0; i < div.size(); i++) {
            if (!isPrime(div.get(i))) {
                pw.println(1);
                pw.println(div.get(i));
                return;
            }
        }
        pw.println(2);
    }

    public boolean isPrime(long x) {
        if (x <= 1) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean hasNext() {
            if (st != null && st.hasMoreTokens()) return true;
            try {
                String s = br.readLine();
                if (s == null || s.isEmpty()) {
                    return false;
                }
                st = new StringTokenizer(s);
            } catch (Exception e) {
            }
            return true;
        }
    }
}
