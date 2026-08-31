import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }

    public static void solve(InputReader sc, PrintWriter pw) {
        int i, j = 0;
        // int t = 1;
        int t=sc.nextInt();
        u: while (t-- > 0) {
            int n=sc.nextInt();
            long l=sc.nextLong();
            long r=sc.nextLong();
            long d=r-l+1;
            long a[]=new long[n+1];
            a[1]=(n-1)*2;
            // pw.println(1+" "+a[1]);
            for(i=2;i<=n;i++){
                a[i]=(n-i)*2+a[i-1];
                // if(i<5)
                //     pw.println(i+" "+a[i]);
            }
            int y=n;
            int low=1,high=n;
            while(low<=high){
                int mid=(low+high)/2;
                if(l<=a[mid]){
                    y=Math.min(y,mid);
                    // low=mid+1;
                    high=mid-1;
                }
                else{
                    // high=mid-1;
                    low=mid+1;
                }
            }
            // y=1;
            // pw.println(y);
            l=l-a[y-1];
            // long d=r-l+1;
            if(l%2==0){
                pw.print((y+(l/2))+" ");
                d--;
            }
            for(long g=l/2+1;y+g<=n&&d>0;g++){
                pw.print((y)+" ");
                d--;
                if(d==0)
                    break;
                pw.print((y+g)+" ");
                d--;
            }
            for(i=y+1;i<=n&&d>0;i++){
                for(long g=i+1;g<=n&&d>0;g++){
                    pw.print(i+" ");
                    d--;
                    if(d==0)
                    break;
                    pw.print(g+" ");
                    d--;
                }
            }
            if(d>0)
                pw.print(1);
            pw.println();
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        // int i;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            // this.i=i;
        }

        public int compareTo(Pair p) {
            if (a != p.a)
                return (a - p.a);
            return (b - p.b);
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}