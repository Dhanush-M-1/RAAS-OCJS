import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static class Task {

        void solve(int test, FastScanner in, PrintWriter out) throws IOException {
            int n = in.nextInt();
            String s = in.nextToken();
            int max = 0;
            char first = '0', second = '1';
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    int ff = 0;
                    for (int l = 0; l < n - 1; l++) {
                        if (s.charAt(l) == 'A' + i && s.charAt(l + 1) == 'A' + j) {
                            ff++;
                        }
                    }
                    if (ff > max) {
                        max = ff;
                        first = (char) ('A' + i);
                        second = (char) ('A' + j);
                    }
                }
            }

            out.println(first + "" + second);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        FastScanner in = new FastScanner("mirrors.in");
//        PrintWriter out = new PrintWriter(new FileWriter("mirrors.out"));
        new Task().solve(1, in, out);
        out.close();
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer token;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(System.in));
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