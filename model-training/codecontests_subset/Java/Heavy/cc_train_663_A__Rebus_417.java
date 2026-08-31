import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Supplier;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;

public class B {
    public String solve(String s) {
        List<String> tokens = asList(s.split(" "));
        int last = Integer.valueOf(tokens.get(tokens.size() - 1));
        long pluses = tokens.stream().filter(string -> string.equals("+")).count();
        long minuses = tokens.stream().filter(string -> string.equals("-")).count();
        long max = (pluses + 1) * last - minuses;
        long min = minuses * (-last) + (pluses + 1);

        if (min <= last && last <= max) {
            List<Long> positive = new ArrayList<>(nCopies((int)pluses + 1, 1L));
            List<Long> negative = new ArrayList<>(nCopies((int)minuses, 1L));
            int curp = 0;
            int curn = 0;
            long sum = positive.stream().reduce(0L, Long::sum) - negative.stream().reduce(0L, Long::sum);
            while (sum != last) {
                if (sum < last) {
                    long incr = Math.min(last - sum, last - positive.get(curp));
                    positive.set(curp, positive.get(curp) + incr);
                    curp++;
                } else {
                    long decr = Math.min(sum - last, last - negative.get(curn));
                    negative.set(curn, positive.get(curn) + decr);
                    curn++;
                }
                sum = positive.stream().reduce(0L, Long::sum) - negative.stream().reduce(0L, Long::sum);
            }
            s = s.replaceFirst("\\?", valueOf(positive.get(0)));
            for (int i = 0; i < pluses; i++) {
                s = s.replaceFirst("\\+ \\?", "+ " + valueOf(positive.get(i + 1)));
            }
            for (int i = 0; i < minuses; i++) {
                s = s.replaceFirst("\\- \\?", "- " + valueOf(negative.get(i)));
            }
            return s;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        // read data
        String res = new B().solve(sc.nextLine());

        if (res == null) {
            pw.println("Impossible");
        } else {
            pw.println("Possible");
            pw.println(res);
        }

        pw.flush();
    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(File f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(f));
        }

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        public String nextLine() throws IOException {
            st = null; // meh
            return br.readLine();
        }
    }
}
