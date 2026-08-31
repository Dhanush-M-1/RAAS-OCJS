import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
            for (int j=0;j<n;j++) {
                ArrayList<Integer> add = new ArrayList<Integer>();
                edge.add(add);
            }
            for (int j=0;j<m;j++) {
                int u = in.nextInt()-1;
                int v = in.nextInt()-1;
                edge.get(u).add(v);
                edge.get(v).add(u);
            }

            boolean[] visited_a = new boolean[n];
            ArrayDeque<Integer> a_q = new ArrayDeque<Integer>();
            a_q.add(a);
            while (!a_q.isEmpty()) {
                int rem = a_q.poll();
                if (rem==b || visited_a[rem]) continue;
                visited_a[rem] = true;
                for (Integer j : edge.get(rem)) {
                    a_q.add(j);
                }
            }

            boolean[] visited_b = new boolean[n];
            ArrayDeque<Integer> b_q = new ArrayDeque<Integer>();
            b_q.add(b);
            while (!b_q.isEmpty()) {
                int rem = b_q.poll();
                if (rem==a || visited_b[rem]) continue;
                visited_b[rem] = true;
                for (Integer j : edge.get(rem)) {
                    b_q.add(j);
                }
            }

            int cnt_a=0;
            int cnt_b=0;
            for (int j=0;j<n;j++) {
                if (visited_a[j] && !visited_b[j]) cnt_a++;
                if (!visited_a[j] && visited_b[j]) cnt_b++;
            }
            out.println((long)(cnt_a-1)*(cnt_b-1));
        }

        out.close();
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
