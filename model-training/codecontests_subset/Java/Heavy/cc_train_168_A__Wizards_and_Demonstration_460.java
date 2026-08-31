import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    private static FastReader fr = new FastReader();
    private static Helper hp = new Helper();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Task solver = new Task();
        solver.solve();
    }

    static class Task {
        public void solve() {
            int n = fr.ni();
            int x = fr.ni();
            int y = fr.ni();
            int req = (int) Math.ceil((y*n)/100.0);
            if(req <= x){
                System.out.println(0);
            }
            else{
                System.out.println(req-x);
            }
        }
    }

    static class Helper {
        public int[] ipArrInt(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fr.ni();
            return arr;
        }

        public long[] ipArrLong(int n, int si) {
            long[] arr = new long[n];
            for (int i = si; i < n; i++)
                arr[i] = fr.nl();
            return arr;
        }
    }

    static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        private static PrintWriter pw;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(System.out);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public String rl() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = fr.ni();
            return arr;
        }

        public void print(String str) {
            pw.print(str);
            pw.flush();
        }
    }
}