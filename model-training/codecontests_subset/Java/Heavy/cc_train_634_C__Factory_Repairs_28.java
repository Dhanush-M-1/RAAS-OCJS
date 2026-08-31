
import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class SolveD {

    public static Reader in;
    public static PrintWriter out;
    public static long mod = 1000000007;
    public static long inf = 100000000000000000l;
    public static long fac[],inv[];
    public static int union[];

    public static void solve(){
        int n = in.nextInt();
        int k = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        int q = in.nextInt();
        
        long arr1[] = new long[n];
        long arr2[] = new long[n];
         int x = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        size = 2 * x - 1;
        left = new long[2 * x - 1];
        right = new long[2 * x - 1];
       
        sizeArray = n;
        
        constructTree(arr1,left);
        constructTree(arr2,right);
        
        while(q-->0)
        {
            int type = in.nextInt();
            if(type == 1)
            {
                int xx = in.nextInt()-1;
                long z = in.nextLong();
                long nn = Math.min(arr1[xx] + z, b);
                long ss = Math.max(0, nn-arr1[xx]);
                updateSegmentTree(arr1, left, xx,ss);
               
                nn = Math.min(arr2[xx] + z, a);
                ss = Math.max(0, nn-arr2[xx]);
                updateSegmentTree(arr2, right, xx,ss);
                
            }
            else
            {
                int start = in.nextInt()-1;
                long ans = 0;
                if(start >0)
                    ans = querySum(arr1,left,0,start-1);
                if(start+k <n)
                    ans += querySum(arr2, right, start+k, n-1);
                out.println(ans);
            }
        }
       // out.println(Arrays.toString(arr2));
        
    }

/**
 *  ############################### Template ################################
 */
      private static long   left[],right[];
    private static int size, sizeArray;
  public static void constructTree(long input[], long segTree[]) {
        constructTree(input, segTree, 0, sizeArray - 1, 0);
    }

    private static void constructTree(long input[], long segTree[], int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructTree(input, segTree, low, mid, 2 * pos + 1);
        constructTree(input, segTree, mid + 1, high, 2 * pos + 2);
        segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];
    }

   public static void updateSegmentTree(long input[], long segTree[], int index, long delta) {
        input[index] += delta;
        updateSegmentTree(input, segTree,index, 0, input.length - 1, delta, 0);
    }

    private static void updateSegmentTree(long input[], long segTree[], int index, int low, int high, long delta, int pos) {
        if (index < low || index > high) {
            return;
        }
        if (low == high) {
           
            segTree[pos] += delta;
            return;
        }
        int mid = (low + high) / 2;
        updateSegmentTree(input, segTree,index, low, mid, delta, 2 * pos + 1);
        updateSegmentTree(input, segTree,index, mid + 1, high, delta, 2 * pos + 2);
        segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];
    }

    public static long querySum(long input[], long segTree[], int qlow, int qhigh) {
        return querySum(input,segTree, qlow, qhigh, 0, sizeArray - 1, 0);
    }

    private static long querySum(long input[], long segTree[], int qlow, int qhigh, int low, int high, int pos) {
        if(low > high)
           return 0;
        
        if (qlow <= low && qhigh >= high) {
            return segTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return 0;
        }
        int mid = (low + high) / 2;
        return querySum(input, segTree,qlow, qhigh, low, mid, 2 * pos + 1) + querySum(input, segTree,qlow, qhigh, mid + 1, high, 2 * pos + 2);
   }

    public static class Pair implements Comparable{
        int x,y;
       
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Object o)
        {
            Pair pp = (Pair)o;
            if(pp.x == x)
                return 0;
            else if (x>pp.x)
                return 1;
            else 
                return -1;
        }
    }

   
    public static void init()
    {
        for(int i=0; i<union.length; i++)
            union[i] = i;
    }
    public static int find(int n)
    {
        return (union[n]==n)?n:(union[n]=find(union[n]));
    }
    public static void unionSet(int i ,int j)
    {
        union[find(i)]=find(j);
    }
    public static boolean connected(int i,int j)
    {   
        return union[i]==union[j];
    }

    public static long gcd(long a, long b) {
        long x = Math.min(a,b);
        long y = Math.max(a,b);
        while(x!=0)
        {
            long temp = x;
            x = y%x;
            y = temp;
        }
        return y;       
    }

    public static long modPow(long base, long exp, long mod) {
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }
            
        }
        return result;
    }
    
    public static void cal()
    {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0]=1;
        inv[0]=1;
        for(int i=1; i<=1000000; i++)
        {
            fac[i]=(fac[i-1]*i)%mod;
            inv[i]=(inv[i-1]*modPow(i,mod-2,mod))%mod;
        }
    }
    public static long ncr(int n, int r)
    {
        return (((fac[n]*inv[r])%mod)*inv[n-r])%mod;
    }


    SolveD() throws IOException {
	in = new Reader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
	solve();
        out.flush();
	out.close();
    }
 
    public static void main(String args[]) {
	new Thread(null, new Runnable() {
            public void run() {
                try {
                    new SolveD();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	}, "1", 1 << 26).start();
    }
    
    public static class Reader {
        public BufferedReader reader;
        public StringTokenizer st;

        public Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public String nextLine() throws IOException{
            return reader.readLine();
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }

    }
}

