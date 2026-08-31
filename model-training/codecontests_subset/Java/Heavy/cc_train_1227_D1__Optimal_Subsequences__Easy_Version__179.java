import java.io.PrintWriter;
import java.util.*;

public class OptimalSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        for (int i = 0; i < t; i++) {
            solve(sc, pw);
        }
        pw.close();
    }
    static class Request{
        int k, pos, idx;

        public Request(int k, int pos, int idx) {
            this.k = k;
            this.pos = pos;
            this.idx = idx;
        }
    }
    static Request[] requests;
    static Map<Integer, Integer> mp;
    static Map<Integer, Integer> rmp;
    static void solve(Scanner in, PrintWriter out){
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();

        requests = new Request[m];
        for (int i = 0; i < m; i++) {
            requests[i] = new Request(in.nextInt(), in.nextInt(), i);
        }
        Arrays.sort(requests, (a, b) -> (a.k - b.k));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{arr[i], i});
        }
        SegTree sg = new SegTree(n + 5);
//        compressValue(arr);
        int cnt = 0;
        int[] rans = new int[m];
        for (int i = 0; i < m; i++) {
            int kv = requests[i].k;
            while (cnt < kv){
                int[] get = pq.poll();
//                System.out.println(Arrays.toString(get));
                sg.modify(get[1], 1);
                cnt++;
            }
//            System.out.println("query:0-1:"+sg.query(0, 1)+" query:0-2:"+sg.query(0, 2)+" query 0-3:"+sg.query(0, 3));
            int id = helper(sg, requests[i].pos, 0, n);
//            System.out.println(" k:"+requests[i].k+" pos:"+requests[i].pos+" id:"+id);
            rans[requests[i].idx] = arr[id];
        }
        for (int i = 0; i < m; i++) {
            out.println(rans[i]);
        }
    }
    static int helper(SegTree sg, int idx, int l, int r){
        while (l < r){
            int mid = (l + r) / 2;
            if (sg.query(0, mid + 1) >= idx){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
    static void compressValue(int[] arr){
        mp = new TreeMap<>();
        rmp = new HashMap<>();
        for(int x : arr) mp.put(x, mp.getOrDefault(x, 0) + 1);
        int cnt = 0;
        for (int k : mp.keySet()) {
            mp.put(k, cnt);
            rmp.put(cnt++, k);
        }
    }

    // Use this instead of Arrays.sort() on an array of ints. Arrays.sort() is n^2
    // worst case since it uses a version of quicksort. Although this would never
    // actually show up in the real world, in codeforces, people can hack, so
    // this is needed.
    static void ruffleSort(int[] a) {
        //ruffle
        int n=a.length;
        Random r=new Random();
        for (int i=0; i<a.length; i++) {
            int oi=r.nextInt(n), temp=a[i];
            a[i]=a[oi];
            a[oi]=temp;
        }

        //then sort
        Arrays.sort(a);
    }

    static class SegTree {
        private int N;

        // Let UNIQUE be a value which does NOT
        // and will not appear in the segment tree
        private long UNIQUE = 0;

        // Segment tree values
        private long[] tree;

        public SegTree(int size) {
            tree = new long[2 * (N = size)];
            java.util.Arrays.fill(tree, UNIQUE);
        }

        public SegTree(long[] values) {
            this(values.length);
            for (int i = 0; i < N; i++) modify(i, values[i]);
        }

        // This is the segment tree function we are using for queries.
        // The function must be an associative function, meaning
        // the following property must hold: f(f(a,b),c) = f(a,f(b,c)).
        // Common associative functions used with segment trees
        // include: min, max, sum, product, GCD, and etc...
        private long function(long a, long b) {
            if (a == UNIQUE) return b;
            else if (b == UNIQUE) return a;

            return a + b; // sum over a range
            //return (a > b) ? a : b; // maximum value over a range
            //return (a < b) ? a : b; // minimum value over a range
            // return a * b; // product over a range (watch out for overflow!)
        }

        // Adjust point i by a value, O(log(n))
        public void modify(int i, long value) {
            //tree[i + N] = function(tree[i + N], value);
            tree[i + N] = value;

            for (i += N; i > 1; i >>= 1) {
                tree[i >> 1] = function(tree[i], tree[i ^ 1]);
            }

        }

        // Query interval [l, r), O(log(n)) ----> notice the exclusion of r
        public long query(int l, int r) {
            long res = UNIQUE;
            for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) != 0) res = function(res, tree[l++]);
                if ((r & 1) != 0) res = function(res, tree[--r]);
            }
            if (res == UNIQUE) {
                //throw new IllegalStateException("UNIQUE should not be the return value.");
                return 0;
            }
            return res;
        }


    }


}
