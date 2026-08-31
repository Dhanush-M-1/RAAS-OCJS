/**
 * Created by Baelish on 9/2/2018.
 */

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class E {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        g = genList(n);
        int u[] = new int[m], v[] = new int[m];
        degree = new int[n];
        dead = new boolean[n];

        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt()-1;
            v[i] = in.nextInt()-1;
            g[u[i]].add(v[i]);
            g[v[i]].add(u[i]);
            degree[u[i]]++;
            degree[v[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if(degree[i] < k) dfs(i);
        }

        int ans[] = new int[m];
        ans[m-1] = n - count;
        for (int i = m-1; i >= 1; i--) {
            if(removedEdge.add( getHash(v[i], u[i]))) {
                degree[u[i]]--;
                degree[v[i]]--;
                dfs(u[i]);
                dfs(v[i]);
            }
            ans[i-1] = n - count;
            if(ans[i-1] == 0) break;
        }

        for(int i : ans) pw.println(i);


        pw.close();
    }
    static List<Integer> g[];
    static boolean dead[];
    static int count = 0, n, m, k;
    static int degree[];
    static HashSet<Long> removedEdge = new HashSet<>();
    static long getHash(long u, long v){
        return (min(u, v) << 30) | max(u, v);
    }

    static void dfs(int u){
        if(dead[u] || degree[u] >= k) return;
        count++;
        dead[u] = true;
        for(int v : g[u]){
            if(!removedEdge.add( getHash(v, u)))  continue;
            degree[u]--;
            degree[v]--;
            dfs(v);
        }
    }


    static <T>List<T>[] genList(int n){
        List<T> list[] = new List[n];
        for(int i = 0; i < n; i++) list[i] = new ArrayList<T>();
        return list;
    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0, charArrayLength = (int) 1e3;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public FastReader(InputStream is, int charArrayLength) {
            this.is = is;
            this.charArrayLength = charArrayLength;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int b = readByte();
            StringBuilder sb = new StringBuilder();
            while (b != '\n' || b != '\r') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char nextChar() {
            return (char) skip();
        }

        private char buff[];

        public char[] nextCharArray() {
            if (buff == null) buff = new char[charArrayLength];
            int b = skip(), p = 0;
            while (!(isSpaceChar(b))) {
                buff[p++] = (char) b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }
    }
}