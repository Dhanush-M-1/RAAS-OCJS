//package CodeForces.C574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class D2 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static long[] li = new long[100005];
    static long mod = 998244353;

    static int len(long num) {
        if (num==0) return 1;
        int ans = 0;
        while(num>0) {
            ans++; num/=10;
        }
        return ans;
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] lenarr = new int[13];
            long[] letpe = new long[20];
            long[] tep = new long[20];
            tep[0]=1;
            for (int i=1;i < 20;i++) {
                tep[i] = (tep[i-1]*10)%mod;
            }
            Arrays.fill(lenarr, 0);
            int[] q = new int[n];
            for (int i=0;i<n;i++) {
                q[i] = in.nextInt();
                lenarr[len(q[i])]++;
                letpe[len(q[i])]++;
            }
            for (int i=1;i<lenarr.length;i++) {
                lenarr[i]+=lenarr[i-1];
            }

            for (int i=1;i<letpe.length;i++) {
                letpe[i] = (letpe[i]*tep[i-1])%mod;
            }

            for (int i=1;i<letpe.length;i++) {
                letpe[i] += letpe[i-1];
            }

            long ans = 0;
            for (int i=0;i<n;i++) {
                if (q[i]==0) continue;
                int tempqi = q[i];
                int pos = 1;
                while(tempqi>0) {
                    int digit = tempqi%10;
                    int counge = n - lenarr[pos-1] ;
                    ans = (ans + ((digit*tep[2*pos-1])%mod * counge)%mod)%mod;
                    ans = (ans + ((digit*tep[2*pos-2])%mod * counge)%mod)%mod;
                    long temp = ((digit * tep[pos])%mod  * letpe[pos-1])%mod;
                    ans = (ans + (temp*2)%mod) %mod;

                    tempqi/=10; pos++;
                }
            }
            out.println(ans);
        }
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

    }
}