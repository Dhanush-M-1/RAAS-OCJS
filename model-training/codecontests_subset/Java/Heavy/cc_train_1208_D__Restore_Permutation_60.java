
import java.io.*;
import java.util.StringTokenizer;

public class mainD {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);
    public static long[] answer;

    public static void main(String[] args) throws IOException {
        int n = enter.nextInt();
        long[] arr = new long[n+1];
        long[] answer = new long[n+1];
        int[] build = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            build[i] = i;
        }
        for (int i = 1; i < n+1; i++) {
            arr[i] = enter.nextLong();
        }
        SegmentTree tree=new SegmentTree(build);
        tree.build(1, 1, n);
        for (int i = n; i >= 1; i--) {
            int element=find(arr[i], tree, n);
            tree.update(1, 1, n, element);
            answer[i]=element;
        }
        for (int i = 1; i <n+1 ; i++) {
            out.print(answer[i]+" ");
        }
        out.close();

    }

    public static int find(long summ, SegmentTree tree, int n){
        int l=1;
        int r=n;
        while(r-l>1){
            int m=(r+l)/2;
            long ans=tree.query(1,1,n,1,m-1);
            if(ans<=summ){
                l=m;
            }
            else{ //summ<ans
                r=m-1;
            }
        }
        if(tree.query(1,1, n,1, r-1)==summ) return r;
        return l;

    }

    static class SegmentTree {
        int[] arr;
        long[] t;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            t = new long[arr.length * 4 + 1];
        }

        public void build(int v, int vl, int vr) {
            if (vl == vr) {
                t[v] = arr[vl];
                return;
            }
            int tmp = (vl + vr) / 2;
            build(2 * v, vl, tmp);
            build(2 * v + 1, tmp + 1, vr);
            t[v] = t[2 * v + 1] + t[2 * v];
        }

        public long query(int v, int vl, int vr, int l, int r) {
            if (l > r) return 0;
            if (vl == l && vr == r) return t[v];
            int tmp = (vl + vr) / 2;
            return query(2 * v, vl, tmp, l, Math.min(tmp, r)) + query(2 * v + 1, tmp + 1, vr, Math.max(l, tmp + 1), r);
        }

        public void update(int v, int vl, int vr, int pos) {
            if (vl == vr) {
                t[v] = 0;
                return;
            }

            int tmp = (vl + vr) / 2;
            if(pos<=tmp){
                update(2*v, vl, tmp, pos);
            }
            else{
                update(2*v+1, tmp+1, vr, pos);
            }
            t[v] = t[2 * v + 1] + t[2 * v];
        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
