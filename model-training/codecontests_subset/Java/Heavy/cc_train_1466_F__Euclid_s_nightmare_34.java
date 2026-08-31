import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main{

    static long MOD = 1_000_000_007L;
    //static long MOD = 998_244_353L;
    //static long MOD = 1_000_000_033L;
    static long [] fac;
    static long [] pow;
    static long [] inv;
    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static long lMax = 0x3f3f3f3f3f3f3f3fL;
    static int iMax = 0x3f3f3f3f;
    static HashMap <Long, Long> memo = new HashMap();
    static HashMap <Long, Long> memof = new HashMap();
    static HashMap <Long, Long> memogL = new HashMap();
    static HashMap <Long, Long> memogR = new HashMap();
    static MyScanner sc = new MyScanner();
    //static ArrayList <Integer> primes;

    static long[] pow2;
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------


        int nn = 500010;

        /*fac = new long[nn + 1];
        fac[1] = 1;
        for(int i = 2; i <= nn; i++)
            fac[i] = fac[i - 1] * 1L * i % MOD;*/

        /*pow = new long[nn + 1];
        pow[0] = 1L;
        for(int i = 1; i <= nn; i++)
            pow[i] = pow[i - 1] * 2L % MOD;
        pow[1] = 3L;*/

        pow2 = new long[nn + 1];
        pow2[0] = 1L;
        for(int i = 1; i <= nn; i++)
            pow2[i] = pow2[i - 1] * 2L % MOD;

        /*inv = new long[nn + 1];
        inv[1] = 1;
        for (int i = 2; i <= nn; ++i)
            inv[i] = (MOD - MOD / i) * inv[(int)(MOD % i)] % MOD;*/

        //primes = sieveOfEratosthenes(100001);


        int t = 1;
        //t = sc.nextInt();
        while(t-- > 0){
            solve();
            //out.println(res);
        }
        out.close();
    }
    static boolean [] visited;
    static ArrayList<Integer>[] neigh;
    static int loopRoot;
    static ArrayList <Integer> cycle;
    static boolean loopEnd;
    static long cnt;

    static int total = 0;
    static long inv2 = (MOD + 1) / 2;

    static int[] par = new int[500010];
    static boolean[] odd = new boolean[500010];
    static void solve() {
        long res = 0L;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <= m; i++) par[i] = i;
        TreeSet <Integer> ans = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp == 2){
                int u = sc.nextInt(), v = sc.nextInt();
                if(union(u, v)){
                    ans.add(i + 1);
                }
            } else{
                int u = sc.nextInt();
                int ru = find(u);
                if(!odd[ru]) {
                    odd[ru] = true;
                    ans.add(i + 1);
                }
            }
        }
        /*
        for(int i = 1; i <= m; i++){
            int tmp = find(i);
            if(makeitodd[tmp] != 500010)
                ans.add(makeitodd[tmp]);
        }*/
        //for(int i = 1; i <= m; i++) System.out.println("root: " + find(i) + " " + odd[par[i]]);
        out.println(pow2[ans.size()] + " " + ans.size());
        for(int i : ans) out.print(i + " ");
        out.println();
    }
    public static boolean union(int i, int j){
        int ri = find(i);
        int rj = find(j);
        if(odd[ri] && odd[rj]) return false;
        if(ri != rj){
            par[ri] = rj;
            odd[rj] |= odd[ri];
            return true;
        }
        return false;
    }
    public static int find(int i){
        if(par[i] == i) return i;
        else return par[i] = find(par[i]);
    }

    // SegmentTree From uwi
    public class SegmentTreeRMQ {
        public int M, H, N;
        public int[] st;

        public SegmentTreeRMQ(int n)
        {
            N = n;
            M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
            H = M>>>1;
            st = new int[M];
            Arrays.fill(st, 0, M, Integer.MAX_VALUE);
        }

        public SegmentTreeRMQ(int[] a)
        {
            N = a.length;
            M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
            H = M>>>1;
            st = new int[M];
            for(int i = 0;i < N;i++){
                st[H+i] = a[i];
            }
            Arrays.fill(st, H+N, M, Integer.MAX_VALUE);
            for(int i = H-1;i >= 1;i--)propagate(i);
        }

        public void update(int pos, int x)
        {
            st[H+pos] = x;
            for(int i = (H+pos)>>>1;i >= 1;i >>>= 1)propagate(i);
        }

        private void propagate(int i)
        {
            st[i] = Math.min(st[2*i], st[2*i+1]);
        }

        public int minx(int l, int r){
            int min = Integer.MAX_VALUE;
            if(l >= r)return min;
            while(l != 0){
                int f = l&-l;
                if(l+f > r)break;
                int v = st[(H+l)/f];
                if(v < min)min = v;
                l += f;
            }

            while(l < r){
                int f = r&-r;
                int v = st[(H+r)/f-1];
                if(v < min)min = v;
                r -= f;
            }
            return min;
        }

        public int min(int l, int r){ return l >= r ? 0 : min(l, r, 0, H, 1);}

        private int min(int l, int r, int cl, int cr, int cur)
        {
            if(l <= cl && cr <= r){
                return st[cur];
            }else{
                int mid = cl+cr>>>1;
                int ret = Integer.MAX_VALUE;
                if(cl < r && l < mid){
                    ret = Math.min(ret, min(l, r, cl, mid, 2*cur));
                }
                if(mid < r && l < cr){
                    ret = Math.min(ret, min(l, r, mid, cr, 2*cur+1));
                }
                return ret;
            }
        }

    }


    public static double dist(double a, double b){
        return Math.sqrt(a * a + b * b);
    }

    public static long inv(long a){
        return quickPOW(a, MOD - 2);
    }

    public class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


    public static int lowerBound(int[] a, int v){ return lowerBound(a, 0, a.length, v); }
    public static int lowerBound(int[] a, int l, int r, int v)
    {
        if(l > r || l < 0 || r > a.length)throw new IllegalArgumentException();
        int low = l-1, high = r;
        while(high-low > 1){
            int h = high+low>>>1;
            if(a[h] >= v){
                high = h;
            }else{
                low = h;
            }
        }
        return high;
    }
    public static long C(int n, int m)
    {
        if(m == 0 || m == n) return 1l;
        if(m > n || m < 0) return 0l;
        long res = fac[n] * quickPOW((fac[m] * fac[n - m]) % MOD, MOD - 2) % MOD;

        return res;
    }
    public static long quickPOW(long n, long m)
    {
        long ans = 1l;
        while(m > 0)
        {
            if(m % 2 == 1)
                ans = (ans * n) % MOD;
            n = (n * n) % MOD;
            m >>= 1;
        }
        return ans;
    }

    public static int gcd(int a, int b)
    {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    public static long gcd(long a, long b)
    {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}
