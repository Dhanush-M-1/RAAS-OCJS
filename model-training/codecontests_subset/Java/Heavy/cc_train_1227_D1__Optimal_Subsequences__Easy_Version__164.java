





import java.io.*;
import java.util.*;
import java.math.BigInteger; 
import java.lang.Object;




public class Main {
    
    
    
    
   static class sort implements Comparator<int[]>
   {
        public int compare(int[] a,int[] b)
        {
            
            if(a[1] == b[1]) return -b[0]+a[0];
            return a[1]-b[1];
        }
   }
   static class sort2 implements Comparator<long[]>
   {
        public int compare(long[] a,long[] b)
        {
            
            //if(a[0] == b[0]) return a[1]-b[1];
           /*if(a[1] < b[1]) return -1;
           else if(a[1] > b[1]) return 1;
           return a[0]-b[0];*/
            return (int)(a[0]-b[0]);
        }
   }
   static class sort1 implements Comparator<double[]>
   {
        public int compare(double[] a,double[] b)
        {
            //if(a[0] == b[0]) return a[1]-b[1];
           if(a[1] < b[1]) return -1;
           else if(a[1] > b[1]) return 1;
           return 0;
        }
   }
   public static String[] F(BufferedReader bf) throws Exception
    {
        return (bf.readLine().split(" "));
    }
    
   public static void pr(PrintWriter out,Object o)
   {
      
    out.println(o.toString());//out.flush();
    
   }
   public static void prW(PrintWriter out,Object o)
   {
      
    out.print(o.toString());//out.flush();
    
   }
   public static int intIn(String st)
   {
      return Integer.parseInt(st);
   }
   
   
    
    public static void pr(Object o)
    {
        System.out.println(o.toString());
    }
    public static void prW(Object o)
    {
        System.out.print(o.toString());
    }
    
   
    public static int inInt(String s)
    {
        return Integer.parseInt(s);
    }
    public static long in(String s)
    {
        return Long.parseLong(s);
    }


    static int[] toIntArray(String[] m) 
    { 
        int[] p=new int[m.length];
        for(int o=0;o<m.length;o++)
        {
            p[o]= inInt(m[o]);
        }
        return p;
    }
    static double[] toDArray(String[] m) 
    { 
        double[] p=new double[m.length];
        for(int o=0;o<m.length;o++)
        {
            p[o]= Double.parseDouble(m[o]);
        }
        return p;
    }
    static long[] toLArray(String[] m) 
    { 
       long[] p=new long[m.length];
        for(int o=0;o<m.length;o++)
        {
            p[o]= in(m[o]);
        }
        return p;
    }
    
    static int[][] di={{0,1},{1,0},{0,-1},{-1,0}};
    static int[] dir = {4,3,2,-4,-3,-2};
    public static void F(int i,int c,int[] vis,List<Integer> res,int n)
    {
        vis[i]=1;
        res.add(i);
        for(int x : dir)
        {
            int v = i+x;
            if(v<=0 || v>n) continue;

            if(vis[v] == 0)
            {
                F(v,c,vis,res,n);
            }
        }
    }
     static long gcd(long a, long b)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b); 
        }
        static long Gp(long l,long b,long lcm)
        {
            long c1,c2;
                c1 = (l/lcm);
                long sum=0l;
                sum += (c1-1l)*(b);
                long las = (l/lcm)*lcm;
                sum += Math.min(l-las+1l,b);
                return sum;
        }
        static long pow(long x, long y, long p)
      {
        long res = 1; // Initialize result
     
        x = x % p; // Update x if it is more than or
        // equal to p
     
        if (x == 0)
          return 0l; // In case x is divisible by p;
     
        while (y > 0)
        {
     
          // If y is odd, multiply x with result
          if ((y & 1) != 0)
            res = (res * x) % p;
     
          // y must be even now
          y = y >> 1; // y = y/2
          x = (x * x) % p;
        }
        return res;
      }
    public static boolean ok(int mid,int[] arr,int[][] mat,int q)
    {
        int tot=0;
        for(int[] a : mat)
        {
            int p=a[0];
            int l = a[1];
            int ans=q+1;
            int g = Math.abs(p);
            if(p==0) continue;
            for(int o=0;o<arr.length;o++)
            {
                if((arr[o]*p) < 0)
                {
                    int sp = Math.abs(arr[o]);
                    int v = (g/sp);
                    if((g%sp) != 0) v++;
                    if(v<=mid)
                    {
                        ans=Math.min(ans,Math.abs(l-o));
                    }
                }
            }

            if(ans > q ) return false;
            tot += ans;
        }

        return tot<=q;
    }
    public static long F(int a,int b)
    {
         return 462161773423l*(a+0l) + 4549834777463l*(b+0l);
    }
    public static void update(int[] diff,int i,long k)
    {
        int j=(int)(k);
        if(j<i) return;
        diff[i] +=1;
        diff[j+1] -=1;
    }
    public static long F(int o)
    {
        long ans=1l;
        long g = 1l;

        while(o>0)
        {
            if((o%2) != 0)
            {
                 ans = (ans * g);
            }
            g++;
            o=(o>>1);

        }

        return ans;
    }
    public static long F(int x,int y,Long[][] dp)
    {
        pr(y);
        if(y<=0)
        {
            return 0l;
        }
        if((10-x) > y)
        {
            dp[x][y] = 1l;return 1l;
        }
        if((10-x) == y)
        {
            dp[x][y] = 2l;return 2l;
        }
        if(dp[x][y] != null)  return dp[x][y];
        long val = F(1,y-(10-x),dp) + F(0,y-(10-x),dp);

        dp[x][y] = val;return val;
    }
    static TreeSet<Long> Fu(long n)
    {
        // Note that this loop runs till square root
        TreeSet<Long> list = new TreeSet<>();

        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i)
                    list.add(i+0l);
      
                else {
                    list.add(i+0l);
                    list.add(n/i);
                }
            }
        }

        return list;
    }
    public static void main (String[] args) throws Exception {
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);;;
        
        //int[] map=new int[1000001];
      
       int yy=1;//inInt(bf.readLine());
       


        
        for(int w=0;w<yy;w++)
        {
            // String str = bf.readLine();
          out.flush();
         
            String[] xlp = bf.readLine().split(" ");;;;;;
            //String st = bf.readLine();
          int n,t;//boolean bol=false;
           int m;//long a,b,c;
           int ioo;
           int k;//pr(out,"vbc");
         n=inInt(xlp[0]);//m=inInt(xlp[1]);//k=inInt(xlp[2]);//t=inInt(xlp[3]);

         int[] arr = toIntArray(F(bf));
         int[] tem = new int[n];
         for(int o=0;o<n;o++) tem[o]=arr[o];
        Arrays.sort(tem);
    xlp = bf.readLine().split(" ");;;;;;
        m=inInt(xlp[0]);k=m;
        Map<Integer,Integer> map=new HashMap<>();
        for(int o=0;o<n;o++)
        {
            if((!map.containsKey(arr[o]))) map.put(arr[o],o);
        }
        for(int o=0;o<k;o++)
        {
            int q1,q2;
            int[] ar = toIntArray(F(bf));
            q1=ar[0];q2=ar[1];
            int ele = tem[n-q1];
            //int index = map.get()
            int co=0;
            for(int j=0;j<n;j++)
            {
                if(arr[j] > ele) co++;
            }
            int ol = q1-co;int ok = 0;
          //  pr(out,co);
            for(int j=0;j<n;j++)
            {
                if(arr[j] > ele || (arr[j]==ele &&  ol>0))
                {
                    ok++;
                    if(ok == q2)
                    {
                        pr(out,arr[j]);break;
                    }
                    if(arr[j] == ele) ol--;
                }
            }




        }

          

         

    }
    out.close();
   bf.close();
}}


/*


1
2
1 1 1 1

100663319,201326611,402653189,805306457,1610612741
Kickstart
 String rp;
            rp = "Case #"+(w+1)+": "+(n-ans)+" ";
static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};

static class SegmentTreeRMQ 
    { 
    int st[]; 
    int minVal(int x, int y) { 
        return (x > y) ? x : y; 
    } 
  
    
    int getMid(int s, int e) { 
        return s + (e - s) / 2; 
    } 
  
    
    int RMQUtil(int ss, int se, int qs, int qe, int index) 
    { 
        
        if (qs <= ss && qe >= se) 
            return st[index]; 
  
        // If segment of this node is outside the given range 
        if (se < qs || ss > qe) 
            return Integer.MIN_VALUE; 
  
        // If a part of this segment overlaps with the given range 
        int mid = getMid(ss, se); 
        return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), 
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2)); 
    } 
  
    // Return minimum of elements in range from index qs (query 
    // start) to qe (query end).  It mainly uses RMQUtil() 
    int RMQ(int n, int qs, int qe) 
    { 
        // Check for erroneous input values 
        
  
        return RMQUtil(0, n - 1, qs, qe, 0); 
    } 
  
    // A recursive function that constructs Segment Tree for 
    // array[ss..se]. si is index of current node in segment tree st 
    int constructSTUtil(int arr[], int ss, int se, int si) 
    { 
        // If there is one element in array, store it in current 
        //  node of segment tree and return 
        if (ss == se) { 
            st[si] = arr[ss]; 
            return arr[ss]; 
        } 
  
        // If there are more than one elements, then recur for left and 
        // right subtrees and store the minimum of two values in this node 
        int mid = getMid(ss, se); 
        st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), 
                constructSTUtil(arr, mid + 1, se, si * 2 + 2)); 
        return st[si]; 
    } 
  
    
    void con(int arr[]) 
    { 
        // Allocate memory for segment tree 
  
        //Height of segment tree 
        int n = (arr.length);
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
  
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
        st = new int[max_size]; // allocate memory 
  
        // Fill the allocated memory st 
        constructSTUtil(arr, 0, n - 1, 0); 
    }
    }
     static class DSU {
    
    int[] p;int[] sz;int op;int c;;
    int[] last;
    public void G(int n)
    {
        last=new int[n];
        p=new int[n];
        sz=new int[n];c=n;
        op=n;
        for(int h=0;h<n;h++)
        {
            sz[h]=1;p[h]=h;
            last[h]=h;
        }
    }
    public int find(int x)
    {
        int y=x;
        while(x!=p[x]) x=p[x];
        while(y!=p[y])
        {
            int tem=p[y];
            p[y]=x;y=tem;
        }
        return p[y];
    }
    public void union(int a,int b)
    {
        int x,y;
        x=find(a);y=find(b);
        if(x==y) return;
        if(sz[x]>sz[y])
        {
            p[y] = x;
            sz[x]+=sz[y];
            last[x]=Math.max(last[x],last[y]);
        }
        else
        {
            p[x]=y;sz[y]+=sz[x];
            last[y]=Math.max(last[y],last[x]);
        }
        c--;
        
    }}

    static long pow(long x, long y, long p)
      {
        long res = 1; // Initialize result
     
        x = x % p; // Update x if it is more than or
        // equal to p
     
        if (x == 0)
          return 0l; // In case x is divisible by p;
     
        while (y > 0)
        {
     
          // If y is odd, multiply x with result
          if ((y & 1) != 0)
            res = (res * x) % p;
     
          // y must be even now
          y = y >> 1; // y = y/2
          x = (x * x) % p;
        }
        return res;
      }
      static long gcd(long a, long b)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b); 
        }
        static int gcd(int a, int b,int o)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b,o); 
        }

Geometric median

public static double F(double[] x,double[] w)
    {
        double d1,d2;
        double S=0.00;
        for(double dp : w) S += dp;
        int k = 0;
        double sum = S - w[0]; // sum is the total weight of all `x[i] > x[k]`

        while(sum > S/2)
        {
            ++k;
            sum -= w[k];
        }
        d1=x[k];
        return d1;
        k = w.length-1;
       sum = S - w[k]; // sum is the total weight of all `x[i] > x[k]`

        while(sum > S/2)
        {
            --k;
            sum -= w[k];
        }
        d2=x[k];
        return new double[]{d1,d2};
    }
*/
