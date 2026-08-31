
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class experiment
{

    static int M = 1_000_000_007;
    static int INF = 1_000_000_000;
    static final FastScanner fs = new FastScanner();

    //variable

    public static void main(String[] args) throws IOException {

        int T = fs.nextInt();
        int[][] dp = new int [200005][10];
        for(int i=0;i<10;i++) dp[0][i] = 1;
        for(int i=1;i<200004;i++) {
            for(int j=0;j<9;j++) {
                dp[i][j] = dp[i-1][j+1];
            }
            dp[i][9] = (dp[i-1][0] + dp[i-1][1])%M;
        }
        PrintWriter out = new PrintWriter(System.out);
        while(T-- > 0) {
            String s = fs.next();
            int n = s.length();
            int m = fs.nextInt();
            int ans = 0;
            for(int i=0;i<n;i++) {
                ans = (ans + dp[m][s.charAt(i) - '0'])%M;
            }
            out.println(ans);
        }
        out.close();
    }
    //function

    static int lcm(int x,int y) {
        return (x / gcd(x,y) * y);
    }
    static int gcd(int x, int y) {
        if(x == 0) return y;

        return gcd(y%x,x);
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
    // Template
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

    static long fastexp(long x, int y){
        if(y==1) return x;

        long ans = fastexp(x,y/2);
        if(y%2 == 0) return modMult(ans,ans);

        return modMult(ans,modMult(ans,x));
    }

    static final Random random = new Random();

    static void ruffleSort(int arr[])
    {
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            int j = random.nextInt(n),temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }


    public static class Pairs implements Comparable<Pairs>
    {
        int value,index;
        Pairs(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int compareTo(Pairs p) {
            return Integer.compare(this.value,p.value);
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

    float nextfloat() throws IOException
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
        int  arr[] = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = nextInt();
        }
        return arr;
    }
}
