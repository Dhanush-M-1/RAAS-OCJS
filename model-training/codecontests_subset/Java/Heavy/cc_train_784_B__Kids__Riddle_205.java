import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }
    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String s = Integer.toHexString(n).toUpperCase();
            int tot = 0;
            Map<Character, Integer> m = new HashMap<>();
            m.put('0', 1);
            m.put('1', 0);
            m.put('2', 0);
            m.put('3', 0);
            m.put('4', 1);
            m.put('5', 0);
            m.put('6', 1);
            m.put('7', 0);
            m.put('8', 2);
            m.put('9', 1);
            m.put('A', 1);
            m.put('B', 2);
            m.put('C', 0);
            m.put('D', 1);
            m.put('E', 0);
            m.put('F', 0);
            for (char c : s.toCharArray()) {
                tot += m.get(c);
            }
            out.println(tot);
        }

    } // wubba lubba dub dub
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
    }
}
