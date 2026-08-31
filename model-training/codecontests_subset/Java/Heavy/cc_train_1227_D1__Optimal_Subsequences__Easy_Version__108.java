import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class OptimalSubsequences {
    InputStream is;
    PrintWriter pw;
    String INPUT = "";
    long L_INF = (1L << 60L);

    void solve() {
        int k,pos,n=ni(), m;
        int a[] = na(n);
        m = ni();
        List<Integer> cache[] = new ArrayList[n];
        while(m-->0){
            k=ni();
            pos = ni();
            if(cache[k-1]==null){
                cache[k-1] = calc(a,k);
            }
            pw.println(cache[k-1].get(pos-1));
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(cache[i]);
//        }

    }

    private List<Integer> calc(int[] a, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x = Integer.compare(o1[0],o2[0]);
                if(x!=0)
                    return x;
                return -Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < a.length; i++) {
            if(pq.size()<k){
                pq.add(new int[]{a[i],i});
            }
            else if(pq.size()==k && pq.peek()[0]<a[i]) {
                pq.poll();
                pq.add(new int[]{a[i], i});
            }
        }
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(!pq.isEmpty()){
            int t[] = pq.poll();
            mp.put(t[1],t[0]);
        }
//        System.out.println(mp);
        List<Integer> ans = new ArrayList<>();
        for (Integer value : mp.values()) {
            ans.add(value);
        }
        return ans;
    }

    void run() throws Exception {
        //		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        is = System.in;
        pw = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
//        int t = ni();
//        while (t-- > 0)
            solve();
        pw.flush();
        tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new OptimalSubsequences().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
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

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
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
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (!oj) System.out.println(Arrays.deepToString(o));
    }
}
