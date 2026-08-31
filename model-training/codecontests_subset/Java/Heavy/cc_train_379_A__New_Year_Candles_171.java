//package GB2013;

import java.io.*;
import java.util.*;

/**
 *
 * @coder Altynbek Nurgaziyev
 */
public class A {

        public void solution() throws Exception {
                int a = in.nextInt(), b = in.nextInt(), c = 0;
                for (int i = 1; i <= a; i++) {
                        if ((++c) % b == 0) {
                                i--;
                        }
                }
                out.println(c);
        }

        Scanner in;
        PrintWriter out;
        String input, output;

        public void run() throws Exception {
                if (input != null) {
                        in = new Scanner(new FileReader(input));
                } else {
                        in = new Scanner(System.in);
                }
                if (output != null) {
                        out = new PrintWriter(new File(output));
                } else {
                        out = new PrintWriter(System.out);
                }
                solution();
                out.close();
        }

        public static void main(String[] args) throws Exception {
                new A().run();
        }

        public class Scanner {

                private final BufferedReader br;
                private StringTokenizer st;

                public Scanner(InputStream is) {
                        br = new BufferedReader(new InputStreamReader(is));
                }

                public Scanner(FileReader fr) {
                        br = new BufferedReader(fr);
                }

                public String next() throws Exception {
                        while (st == null || !st.hasMoreTokens()) {
                                st = new StringTokenizer(br.readLine());
                        }
                        return st.nextToken();
                }

                public Integer nextInt() throws Exception {
                        return Integer.parseInt(next());
                }

                public Long nextLong() throws Exception {
                        return Long.parseLong(next());
                }

                public Double nextDouble() throws Exception {
                        return Double.parseDouble(next());
                }
        }
}
