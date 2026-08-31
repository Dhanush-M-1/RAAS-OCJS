import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class R294B {

    static char[][] a;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();      
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (a.containsKey(x)) {
                a.put(x, a.get(x) + 1);
            } else 
                a.put(x, 1);
        }
        for (int i = 0; i < n-1; i++) {
            int x = in.nextInt();
            if (a.get(x) > 1) {
                a.put(x, a.get(x) - 1);
            } else {
                a.remove(x);                
            }
            if (b.containsKey(x)) {
                b.put(x, b.get(x) + 1);
            } else 
                b.put(x, 1);
        }
        int first = 0;
        for (Integer k : a.keySet()) {
            first = k;
            break;
        }
        for (int i = 0; i < n-2; i++) {
            int x = in.nextInt();
            if (b.get(x) > 1) {
                b.put(x, b.get(x) - 1);
            } else {
                b.remove(x);                
            }
        }
        int second = 0;
        for (Integer k : b.keySet()) {
            second = k;
            break;
        }
        out.println(first);
        out.println(second);
        
        out.flush();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
