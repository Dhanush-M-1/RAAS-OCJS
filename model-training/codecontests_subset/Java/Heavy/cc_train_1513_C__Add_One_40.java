import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
public class Main extends PrintWriter {
    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));Main () { super(System.out); }public static void main(String[] args) throws IOException{ Main  d1=new Main   ();d1.main();d1.flush(); }

    void main() throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int t = 1;
        t = i(s()[0]);
         int mod = 1000000007;
         int[][] ndp = new int[2 * 100005 + 5][10];
        int[][] dp = new int[2 * 100005 + 5][10];
        int[][] ans = new int[2 * 100005 + 5][10];

        for(int j = 0; j < 10; j++){
            int no = j;
            
            dp[0][j] = 1;
             for(int i = 1; i < 2 * 100005; i++) {
                 ndp[i][1] = (dp[i - 1][9] + dp[i - 1][0]) % mod;
                 ans[i][j] += ndp[i][1];
                 ans[i][j] %= mod;
                 ndp[i][0] =  dp[i - 1][9];
                 ans[i][j] += ndp[i][0];
                 ans[i][j] %= mod;
                 ndp[i][2] = dp[i - 1][1];
                 ans[i][j] += ndp[i][2];
                 ans[i][j] %= mod;
                 ndp[i][3] = dp[i - 1][2];
                 ans[i][j] += ndp[i][3];
                 ans[i][j] %= mod;
                 ndp[i][4] = dp[i - 1][3];
                 ans[i][j] += ndp[i][4];
                 ans[i][j] %= mod;
                 ndp[i][5] = dp[i - 1][4];
                 ans[i][j] += ndp[i][5];
                 ans[i][j] %= mod;
                 ndp[i][6] = dp[i - 1][5];
                 ans[i][j] += ndp[i][6];
                 ans[i][j] %= mod;
                 ndp[i][7] = dp[i - 1][6];
                 ans[i][j] += ndp[i][7];
                 ans[i][j] %= mod;
                 ndp[i][8] = dp[i - 1][7];
                 ans[i][j] += ndp[i][8];
                 ans[i][j] %= mod;
                 ndp[i][9] = dp[i - 1][8];
                 ans[i][j] += ndp[i][9];
                 ans[i][j] %= mod;
           //      System.out.println(ans[i][j] + " " + i + " " + j);
                 dp = ndp;
             }  dp[0][j] = 0;

        }
        while (t-- > 0) {
           String[] s1 = s();
           int n = i(s1[0]);
           int m = i(s1[1]);
          int fans = 0;
           int x = n;
           while(x > 0){
               int c = x % 10;
//               System.out.println(c);
               fans = (fans + ans[m][c]) % mod;
               x /= 10;
           }

           sb.append(fans + "\n");
        }
        System.out.println(sb);
    }
        static long[] fac ;static int MAXN1;
            static void calculatefac(int mod){
                fac[0]=1;
                for (int i = 1 ;i <= MAXN1; i++)
                    fac[i] = fac[i-1] * i % mod;
            }static long modInverse(long a, long m) {
                return (powerwithmod(a, m - 2, m));
            }
            static long powerwithmod(long  x, long y, long p) {
                long res = 1;
                x = x % p;
                while (y > 0) {
                    if ((y & 1) == 1)
                        res = (res * x) % p;
                    y = y >> 1;
                    x = (x * x) % p;
                }
                return res;
            }
            static long nCrModPFermat(int n, int r, long mod) {
                if (r == 0)
                    return 1;
                fac[0] = 1;
                return (fac[n]*
                        modInverse(fac[r], mod)
                        % mod * modInverse(fac[n-r], mod)
                        % mod) % mod;
            }

    static String[] s() throws IOException { return s.readLine().trim().split("\\s+"); }
    static int i(String ss) {return Integer.parseInt(ss); }
    static long l(String ss) {return Long.parseLong(ss); }
    public void arr(long[] a,int n) throws IOException {String[] s2=s();for(int i=0;i<n;i++){ a[i]=l(s2[i]); }}
    public void arri(int[] a,int n) throws IOException {String[] s2=s();for(int i=0;i<n;i++){ a[i]=i(s2[i]); }}
}class Pair{
    int ind; long h;
    public Pair(int ind, long val){
        this.ind = ind;
        this.h = val;
    }
}


