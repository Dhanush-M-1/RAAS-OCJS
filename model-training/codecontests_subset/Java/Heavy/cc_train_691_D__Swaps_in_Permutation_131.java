import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.concurrent.*;

public class Main {
    //---------------------------------------------------------------------------

    static int n, m;
    static int[] a, res;
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static ArrayList<Integer> num, pos;

    static void dfs(int u) {
        if (vis[u]) {
            return;
        }
        vis[u] = true;
        num.add(a[u]);
        pos.add(u);
        for (int i = 0; i < g[u].size(); i++) {
            int v = g[u].get(i);
            dfs(v);
        }
    }

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //-----------------------------------------------------------------------
        n = in.nextInt();
        m = in.nextInt();
        a = new int[n];
        res = new int[n];
        vis = new boolean[n];
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            g[x].add(y);
            g[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                num = new ArrayList();
                pos = new ArrayList();
                dfs(i);
                Collections.sort(num);
                Collections.sort(pos);
                int k = pos.size();
                for (int j = 0; j < k; j++) {
                    res[pos.get(j)] = num.get(k - 1 - j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.println();
        //-----------------------------------------------------------------------
        out.close();
    }

    //---------------------------------------------------------------------------
    static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static class Pair<F, S> implements Comparable<Pair<F, S>> {

        F first;
        S second;

        public Pair() {

        }

        public Pair(F f, S s) {
            this.first = f;
            this.second = s;
        }

        @Override public boolean equals(Object o) {
            Pair<F, S> p = (Pair<F, S>) o;
            if (first.equals(p.first) && second.equals(p.second)) {
                return true;
            }
            return false;
        }

        public int compareTo(Pair<F, S> p) {
            int ret = ((Comparable<F>) first).compareTo(p.first);
            if (ret == 0) {
                ret = ((Comparable<S>) second).compareTo(p.second);
            }
            return ret;
        }
    }

    static class BitMask {
        private int mask;

        public BitMask() {
            mask = 0;
        }

        public BitMask(BitMask b) {
            mask = b.getMask();
        }

        public BitMask(int i) {
            mask = i;
        }

        public int getMask() {
            return mask;
        }

        public void setMask(int i) {
            mask = i;
        }

        public int get(int i) {
            return (mask >> i) & 1;
        }

        public void set(int i, int v) {
            if (v == 0) {
                mask = mask & ~(1 << i);
            } else {
                mask = mask | (1 << i);
            }
        }

        public void set(int v) {
            for (int i = 0; i < 32; i++) {
                set(i, v);
            }
        }

        public void flip(int i) {
            mask = mask ^ (1 << i);
        }

        public void flip() {
            for (int i = 0; i < 31; i++) {
                flip(i);
            }
        }

        public int count() {
            int ret = 0;
            for (int i = 0; i < 32; i++) {
                if (get(i) == 1) {
                    ret++;
                }
            }
            return ret;
        }

        public static int grayCode(int i) {
            return i ^ (i >> 1);
        }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] nextCharArray() {
            return next().toCharArray();
        }

        public boolean hasNext() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String s = reader.readLine();
                    if (s == null) {
                        return false;
                    }
                    tokenizer = new StringTokenizer(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return true;
        }

        public void skipLine() {
            try {
                tokenizer = null;
                reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}