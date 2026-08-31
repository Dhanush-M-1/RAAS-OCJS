
import java.io.*;
import java.util.*;

public class codeforces
{
    static int M = 1_000_000_007;
    static int INF = 2_000_000_000;
    static final FastScanner fs = new FastScanner();

    //variable

    public static void main(String[] args) throws IOException {

            int n = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[][] dp  = new int[n+1][3];
            dp[1][1] = 1;
            dp[n][2] = 1;
            for(int i=0;i<n;i++) {
                a[i] = fs.nextInt();
                b[i] = fs.nextInt();
            }
            int ans = 1;
            for(int i=2;i<=n;i++) {
                if(i == n){
                    ans = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]))+1;
                    continue;
                }
                int max = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
                dp[i][0] = max;
                if(a[i-1]-b[i-1] > a[i-2]) {
                    dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0])+1;
                    if(a[i-2]+b[i-2] < a[i-1]-b[i-1]) dp[i][1] = Math.max(dp[i][1],dp[i-1][2]+1);
                }
                if(a[i] > a[i-1]+b[i-1]) dp[i][2] = max+1;
            }
        System.out.println(ans);
    }
    //class

    //function

    // Template
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static int gcd(int a, int b) {
        if(a==0) return b;

        return gcd(b%a,a);
    }
    static void premutation(int n, ArrayList<Integer> arr,boolean[] chosen) {
        if(arr.size() == n) {

        }else {
            for(int i=1; i<=n; i++) {
                if(chosen[i]) continue;
                arr.add(i);
                chosen[i] = true;
                premutation(n,arr,chosen);
                arr.remove(i);
                chosen[i] = false;
            }
        }
    }
    static boolean isPalindrome(char[] c) {
        int n = c.length;
        for(int i=0; i<n/2; i++) {
            if(c[i] != c[n-i-1]) return false;
        }
        return true;
    }

    static long nCk(int n, int k) {
        return (modMult(fact(n),fastexp(modMult(fact(n-k),fact(k)),M-2)));
    }

    static long fact (long n) {

        long fact =1;
        for(int i=1; i<=n; i++) {
            fact = modMult(fact,i);
        }
        return fact%M;
    }

    static int modMult(long a,long b) {
        return (int) (a*b%M);
    }
    static int negMult(long a,long b) {
        return (int)((a*b)%M + M)%M;
    }
    static long fastexp(long x, int y){
        if(y==1) return x;

        long ans = fastexp(x,y/2);
        if(y%2 == 0) return modMult(ans,ans);
        else return modMult(ans,modMult(ans,x));
    }

    static final Random random = new Random();

    static void ruffleSort(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            int j = random.nextInt(n);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }


    public static class Pairs implements Comparable<Pairs>
    {
        long f,s;
        Pairs(long f, long s)
        {
            this.f = f;
            this.s = s;
        }
        public int compareTo(Pairs p)
        {
            return Long.compare(this.f,p.f);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pairs)) return false;
            Pairs pairs = (Pairs) o;
            return f == pairs.f && s == pairs.s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, s);
        }
    }
}
class FastScanner
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer("");

    String next() throws IOException
    {
        while(!str.hasMoreTokens())
            str = new StringTokenizer(br.readLine());

        return str.nextToken();
    }

    char nextChar() throws IOException {
        return next().charAt(0);
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    float nextFloat() throws IOException
    {
        return Float.parseFloat(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
    byte nextByte() throws IOException
    {
        return Byte.parseByte(next());
    }
    int [] arrayIn(int n) throws IOException
    {
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = nextInt();
        }
        return arr;
    }
}

