/**
 * Created by Aminul on 1/28/2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main{

    static int a[][], n, m;
    static Map<Integer, Integer> map[];

    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        n = in.nextInt(); m = in.nextInt();
        a = new int[3][m];
        List<Integer> g[] = intList(n);
        map = intMap(n);
        for (int i = 0; i < m; i++) {
            int l = in.nextInt()-1, r = in.nextInt()-1, d = in.nextInt();
            Integer v = map[l].get(r);
            if(v != null && !v.equals(d)){
                pw.println("No"); pw.close(); return;
            }
            map[l].putIfAbsent(r, d);
            g[l].add(r);
            a[0][i] = l; a[1][i] = r; a[2][i] = d;
        }

        int order[] = new TopologicalSort().topologicalSort(g);
        int ans[] = new int[n+1]; Arrays.fill(ans, Integer.MIN_VALUE);

 
        ans[order[0]] = 0;
        for(int l: order){
            int x = Integer.MIN_VALUE;
            if(ans[l] == Integer.MIN_VALUE){
                for(int r : map[l].keySet()){
                    int d = map[l].get(r);
                    if(ans[r] != x){
                        x = ans[r]; ans[l] = x-d;
                        break;
                    }
                }
                if(x == Integer.MIN_VALUE) ans[l] = 0;
            }
           
            for(int r : map[l].keySet()){
                int d = map[l].get(r);
                ans[r] = ans[l] + d;
            }
        }
      

        boolean ok = true;
        for(int i = 0; i < m; i++){
            if((ans[a[1][i]] == Integer.MIN_VALUE || ans[a[0][i]] == Integer.MIN_VALUE)) continue;
            ok &= ( (ans[a[1][i]] - ans[a[0][i]]) == a[2][i]);
        }

        if(ok) pw.println("Yes");
        else pw.println("No");


        pw.close();
    }

    static void reverseArray(int a[]){
        for(int i = 0, j = a.length-1; i < j; i++, j--){
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
    }

    static List<Integer>[] intList(int n){
        List<Integer> list[] = new List[n];
        for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
        return list;
    }
    static Map<Integer, Integer>[] intMap(int n){
        Map<Integer, Integer> map[] = new Map[n];
        for(int i = 0; i < n; i++) map[i] = new HashMap<>();
        return map;
    }


    static class TopologicalSort {
        boolean used[];
        List<Integer>[] graph;
        int order[], idx;

        void dfs(int u) {
            used[u] = true;
            for (int v : graph[u]) {
                if (!used[v]) {
                    dfs(v);
                }
            }
            order[--idx] = u;
        }

        int[] topologicalSort(List<Integer>[] g) {
            graph = g;
            int n = graph.length;
            used = new boolean[n];
            order = new int[n];
            idx = n;
            for (int i = 0; i < n; i++)
                if (!used[i])
                    dfs(i);
            return order;
        }
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is){
            for(int i='0';i<='9';i++) ints[i]=i-'0';
            this.is = is;
        }

        public int readByte(){
            if(lenbuf == -1)throw new InputMismatchException();
            if(ptrbuf >= lenbuf){
                ptrbuf = 0;
                try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                if(lenbuf <= 0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() {
            int b;
            while((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next(){
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt(){
            int num = 0, b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
       /* public char nextChar() {
            return (char)skip();
        }*/

        public char[] next(int n){
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while(p < n && !(isSpaceChar(b))){
                buf[p++] = (char)b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        /*private char buff[] = new char[1005];
        public char[] nextCharArray(){
            int b = skip(), p = 0;
            while(!(isSpaceChar(b))){
                buff[p++] = (char)b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }*/
    }
}