import java.io.IOException;
import java.util.*;
public class d {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
       //         BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        int n=s.nextInt();
    int keys=s.nextInt();
    long office=s.nextLong();
        long[] p=new long[n];
        for(int i=0;i<n;i++) {
            p[i]=s.nextLong();
        }long[] k=new long[keys];
        for(int i=0;i<keys;i++){
            k[i]=s.nextLong();
        }
        Arrays.sort(p);
        Arrays.sort(k);long[][] dp=new long[n][keys];
long fans=Integer.MAX_VALUE;
        long[][] Dp=new long[n][keys];
        for(int i=0;i<keys;i++){
            dp[0][i]=Math.abs(p[0]-k[i])+Math.abs(k[i]-office);
            fans=Math.min(fans,dp[0][i]);
            Dp[0][i]=dp[0][i];
            //  System.out.println(i+" "+dp[0][i]);
        }long ans=Long.MAX_VALUE;//long fans=0;
        if(n>1) fans=Long.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            long min=dp[i][i];ans=Long.MAX_VALUE;
            for(int j=i+1;j<keys;j++){
                dp[i+1][j]=min+Math.abs(p[i+1]-k[j])+Math.abs(k[j]-office);
                Dp[i+1][j]=Math.max(Math.abs(p[i+1]-k[j])+Math.abs(k[j]-office),Dp[i][j-1]);
                min=Math.min(dp[i][j],min);
                //   ans=Math.min(ans,dp[i+1][j]-min);
                if(i==n-2) fans=Math.min(fans,Dp[i+1][j]);

            }}
        System.out.println(fans);

    }
    static int[] vis;
    public static int countSetBits(int n)
    {
        return (BitsSetTable256[n & 0xff]
                + BitsSetTable256[(n >> 8) & 0xff]
                + BitsSetTable256[(n >> 16) & 0xff]
                + BitsSetTable256[n >> 24]);
    }
    static int[] BitsSetTable256 ;
    public static void initialize(int n)
    {
        BitsSetTable256[0] = 0;
        for (int i = 0; i <=Math.pow(2,n); i++) {
            BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
        }
    }
    static HashMap<Integer,Integer>[] val;//static int[] vis;static int y;
    static boolean dfs(int x ,int i,ArrayList<Integer>[] adj){
      vis[i]=1;
     // if(x==1) System.out.print(i+" ");
      if(adj[i]==null) return false;
      for(int j:adj[i]){
        //  if(x==1) System.out.print(j+" ");
          if(j==x) return true;
          if(vis[j]==0) return dfs(x,j,adj);
      }return false;
    }

    static  void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
    static long powerwithmod(long  x, long y, int p) {
        long  res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    static long  powerwithoutmod(long x, int y) {
        long  temp;
        if( y == 0)
            return 1;
        temp = powerwithoutmod(x, y/2);
        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
    static void fracion(double x) {
        String a = "" + x;
        String spilts[] = a.split("\\."); // split using decimal
        int b = spilts[1].length(); // find the decimal length
        int denominator = (int) Math.pow(10, b); // calculate the denominator
        int numerator = (int) (x * denominator); // calculate the nerumrator Ex
        // 1.2*10 = 12
        int gcd = (int) gcd((long) numerator, denominator); // Find the greatest common
        // divisor bw them
        String fraction = "" + numerator / gcd + "/" + denominator / gcd;
        // System.out.println((denominator/gcd));
        long x1 = modInverse(denominator / gcd, 998244353);
        //  System.out.println(x1);
        System.out.println((((numerator / gcd) % 998244353 * (x1 % 998244353)) % 998244353));
    }
    static int bfs(int i1, ArrayList<Integer>[] h, int[] vis, int n,int val1) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i1);Queue<Integer> aq=new LinkedList<Integer>();
        aq.add(0);
        while(!q.isEmpty()){
            int i=q.poll();
            int val=aq.poll();
            if(i==n){
                return val;
            }
            if(h[i]!=null){
                for(Integer j:h[i]){
                    if(vis[j]==0){
                        q.add(j);vis[j]=1;
                        aq.add(val+1);}
                }
            }
        }return -1;
    }
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static long modInverse(long a, int m)
    {
        return (powerwithmod(a, m - 2, m));
    }
    static int MAXN=100001;
    static int[] spf=new int[MAXN];
    static void sieve() {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
            spf[i] = i;
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;
        for (int i=3; i*i<MAXN; i++)
        {
            if (spf[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)

                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }
    static Vector<Integer> getFactorizationUsingSeive(int x) {
        Vector<Integer> ret = new Vector<Integer>();
        while (x != 1)
        {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }
   /* static long[] fac = new long[MAXN+1];
     static void calculatefac(int mod){
        for (int i = 1 ;i <= MAXN; i++)
            fac[i] = fac[i-1] * i % mod;
     }
      static long nCrModPFermat(int n, int r, int mod) {
         if (r == 0)
            return 1;
        fac[0] = 1;
        return (fac[n]* modInverse(fac[r], mod)
                % mod * modInverse(fac[n-r], mod)
                                    % mod) % mod;
    } */}
class Student {
    int l;int r;int x;
    public Student(int l, int r,int x) {
        this.l = l;this.x=x;
        this.r = r;
    }

    public String toString()
    {
        return this.l+" ";
    }
}
class Sortbyroll implements Comparator<Student>
{

    public int compare(Student a, Student b){
        return b.x-a.x;  }
}
class Sortbyroll1 implements Comparator<Student> {
    public int compare(Student a, Student b){
        if(a.r==b.r) return a.l-b.l;
        return b.l-a.l;
    }
}