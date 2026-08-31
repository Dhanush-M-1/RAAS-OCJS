import java.util.*;
import java.io.*;
import java.text.*;
public class Gymaya  {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int N = 1; while(N < n) N <<= 1; //padding

        long[] in = new long[N + 1];
        long inf= (long) 1e17;
        Arrays.fill(in,inf);
        for(int i = 1; i <= n; i++)
            in[i] = sc.nextLong();
        SegmentTree sg = new SegmentTree(in);
        int[]ans= new int[n+1];
        for (int i =1;i<=n;i++){
            int id= sg.query(1,n);
            ans[id]=i;
            sg.update_range(id+1,n,-i);
            sg.update_point(id,inf);
        }
        for (int i =1;i<=n;i++){
            pw.print(ans[i]+" ");
        }
        pw.println();
        pw.flush();
    }
    static class SegmentTree {        // 1-based DS, OOP

        int N;            //the number of elements in the array as a power of 2 (i.e. after padding)
        int[]  sTree;
        long[] array,lazy;
        SegmentTree(long[] in) {
            array = in;
            N = in.length - 1;
            sTree = new int[N << 1];        //no. of nodes = 2*N - 1, we add one to cross out index zero
            lazy = new long[N << 1];
            build(1, 1, N);
        }

        void build(int node, int b, int e)    // O(n)
        {
            if (b == e)
                sTree[node] = b;
            else {
                int mid = b + e >> 1;
                build(node << 1, b, mid);
                build(node << 1 | 1, mid + 1, e);
                if (array[sTree[node<<1]]<array[sTree[node << 1 | 1]]){
                    sTree[node]=sTree[node<<1];
                }
                else sTree[node]=sTree[node<<1 | 1];
            }
        }


        void update_point(int index, long val)            // O(log n)
        {
            array[index]=val;
            index += N - 1;
            while (index > 1) {
                index >>= 1;
                propagate(index,0,0,0);
                if (array[sTree[index<<1]]<array[sTree[index << 1 | 1]]){
                    sTree[index]=sTree[index<<1];
                }
                else sTree[index]=sTree[index << 1|1];
            }
        }


        void update_range(int i, int j, int val)        // O(log n)
        {
            update_range(1, 1, N, i, j, val);
        }

        void update_range(int node, int b, int e, int i, int j, int val) {
            if (i > e || j < b)
                return;
            if (b >= i && e <= j) {
                array[sTree[node]]+=val;
                lazy[node] += val;
            } else {
                int mid = b + e >> 1;
                propagate(node, b, mid, e);
                update_range(node << 1, b, mid, i, j, val);
                update_range(node << 1 | 1, mid + 1, e, i, j, val);
                if (array[sTree[node<<1]]<array[sTree[node << 1 | 1]]){
                    sTree[node]=sTree[node<<1];
                }
                else sTree[node]=sTree[node<<1 | 1];
            }
        }

        void propagate(int node, int b, int mid, int e) {
            lazy[node << 1] += lazy[node];
            lazy[node << 1 | 1] += lazy[node];
            if (sTree[node<<1]!=sTree[node])
                array[sTree[node << 1]] += lazy[node];
            if (sTree[node<<1 | 1 ]!=sTree[node])
                array[sTree[node << 1 | 1]] += lazy[node];
            lazy[node] = 0;
        }

        int query(int i, int j) {
            return query(1, 1, N, i, j);
        }

        int query(int node, int b, int e, int i, int j)    // O(log n)
        {
            if (i > e || j < b)
                return -1;
            if (b >= i && e <= j)
                return sTree[node];
            int mid = b + e >> 1;
            propagate(node, b, mid, e);
            int q1 = query(node << 1, b, mid, i, j);
            int q2 = query(node << 1 | 1, mid + 1, e, i, j);
            if (q1==-1)return q2;
            if (q2==-1)return q1;
            if (array[q1]<array[q2])return q1;
            return q2;
        }
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}