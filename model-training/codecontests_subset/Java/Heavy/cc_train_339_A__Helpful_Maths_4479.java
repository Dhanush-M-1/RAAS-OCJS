import java.io.*;
import java.util.*;

public class A_Helpful_Maths {
    double PI = 3.141592653589793238462643383279502884197169399375105820974944;
    int MOD = 1000000007;

    public static void main(String[] args) {
        FastScanner f = new FastScanner();
        String arr[] = f.rs().split("");
        int len = arr.length;
        int inp[] = new int[len / 2 + 1];
        // System.out.println(inp.length);
        int ii=0;
        for (int i = 0; i < len;) {
            inp[ii] = Integer.parseInt(arr[i]);
            i = i + 2;
            ii++;
            if (i >= len) {
                break;
            }
        }
        Arrays.sort(inp);
        int n=inp.length;
        for(int i=0;i<n;i++){
            if(i==n-1){
                System.out.print(inp[i]);
            }
            else{
                System.out.print(inp[i]+"+");
            }
        }

    }

    // any other class you make,make it static.

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String rs() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int ri() {
            return Integer.parseInt(rs());
        }

        int[] rarr(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = ri();
            return a;
        }

        long rl() {
            return Long.parseLong(rs());
        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static long ncr(int n, int k) // note it returns long
    {
        if (k > n - k) {
            k = n - k;
        }
        long c[] = new long[k + 1];
        c[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                c[j] = c[j] + c[j - 1];
                // c[j]=c[j]%(1000000000+7);when asked or int is used instead of long
            }
        }
        return c[k];
    }

}
