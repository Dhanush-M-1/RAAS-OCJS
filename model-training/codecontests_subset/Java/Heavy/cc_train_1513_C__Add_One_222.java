import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
public class Main{
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
        long[] nextArray(long n) {
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static class FastWriter extends PrintWriter {
            FastWriter(){
                super(System.out);
            }
            void println(int[] array) {
                for(int i=0; i<array.length; i++) {
                    print(array[i]+" ");
                }
                println();
            }
            void println(long [] array) {
                for(int i=0; i<array.length; i++) {
                    print(array[i]+" ");
                }
                println();
            }
        }
    public static void main(String[] args){
        FastScanner in = new FastScanner();
        FastWriter out = new FastWriter();
        long[] dp=new long[200005];
        dp[0]=2;dp[1]=2;dp[2]=2;dp[3]=2;dp[4]=2;dp[5]=2;dp[6]=2;dp[7]=2;dp[8]=2;dp[9]=3;
        for (int i = 10; i < 200005; i++) {
            dp[i]=(dp[i-9]+dp[i-10])%1000000007;
        }
        int t=in.nextInt();
        while (t-->0){
            int n=in.nextInt();
            int m=in.nextInt();
            long ans=0L;
            while (n!=0){
                int diff=m-(10-(n%10));
                if(m+n%10>=10){
                    ans+=dp[diff];
                }else {
                    ans++;
                }
                ans%=1000000007;
                n/=10;
            }
            out.println(ans);
        }
        out.close();
    }
}