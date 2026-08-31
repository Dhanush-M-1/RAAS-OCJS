import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {

    static class MainA1 {

        private void solve(int test, FastScanner in, PrintWriter out) {
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                int d = in.nextInt();
                int x = (r + 1) % d;
                if(d < l || d > r){
                    out.println(d);
                } else if (r % d == 0) {
                    out.println(r + d);
                } else {
                    out.println(r - r % d + d);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//         FastScanner in = new FastScanner("input.txt");
//         PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        new MainA1().solve(1, in, out);
        out.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer token;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken() {
            while (token == null || !token.hasMoreTokens()) {
                try {
                    token = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}