import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            long a = sc.nextLong(); long b = sc.nextLong(); long c = sc.nextLong(); long d = sc.nextLong();
            if (a < b || d < b) {
                out.println("No");
                continue;
            }
            long gcd = gcd(b, d);
            long init = a % gcd;
            long max = b - gcd + init;
            if (c >= max) out.println("Yes"); else out.println("No");
        }
        out.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }

}