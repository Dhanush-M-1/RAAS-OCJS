
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskD {
        static int[] num;
        static int n , k ;
        static long[][][] dp = new long[100][4][2];
        static long ok(int pos , int nonz , int ch1) {
            if (nonz > k) return 0;
            if (pos == n) {
                if (nonz == k) return 1;
                return 0;
            }
            if (dp[pos][nonz][ch1] != -1) return dp[pos][nonz][ch1];
            long res = 0;
            int lmt = 0;
            if (ch1 == 1) lmt = 9;
            else lmt = num[pos];
            for (int i = 0; i <= lmt; i++) {
                int n1 = nonz;
                int n2 = ch1;
                if (ch1 == 0 && i < lmt) n2 = 1;
                if (i != 0) n1++;
                if (n1 <= k) res += ok(pos + 1, n1, n2);
            }
            dp[pos][nonz][ch1] = res;
            return res;
        }
        public void solve(int testNumber, InputReader in, PrintWriter out){
            for (int i = 0; i <dp.length; i++) {
                for (int j = 0; j <dp[i].length ; j++) {
                    for (int l = 0; l <dp[i][j].length ; l++) {
                        dp[i][j][l]=-1;
                    }
                }
            }
            String s = in.next();
            k = in.nextInt();
            n =s.length();
            num = new int[s.length()];
            for (int i = 0; i <n; i++) {
                num[i]=s.charAt(i)-'0';
            }
            System.out.println(ok(0,0,0));





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
        public int nextInt(){return  Integer.parseInt(next());}
        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}