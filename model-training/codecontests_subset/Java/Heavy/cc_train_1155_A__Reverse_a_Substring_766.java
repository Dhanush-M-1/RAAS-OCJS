import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    private static class Solver {

        private void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.next();

            int a = -1, b = -1;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) > s.charAt(i + 1)) {
                    a = i + 1;
                    b = i + 2;
                    break;
                }
            }

            if (a == -1) {
                out.println("NO");
            } else {
                out.println("YES");
                out.println(a + " " + b);
            }
        }
    }

    private static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}