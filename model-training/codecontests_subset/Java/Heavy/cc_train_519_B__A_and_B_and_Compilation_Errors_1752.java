import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class CodeForces {

    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();

        int a = 0, b = 0, c = 0;

        for (int idx = 0; idx < n; idx++) {
            a += in.nextInt();
        }

        for (int idx = 0; idx < n - 1; idx++) {
            b += in.nextInt();
        }


        for (int idx = 0; idx < n - 2; idx++) {
            c += in.nextInt();
        }

        out.println(a-b);
        out.println(b - c);

        out.close();
    }

    public static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(in));
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