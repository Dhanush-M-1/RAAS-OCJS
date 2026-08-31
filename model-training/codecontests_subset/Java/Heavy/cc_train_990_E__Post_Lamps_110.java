import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Test12  {
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
    public static void main(String[] Args)   {
           InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        boolean[] can = new boolean[n];
        int[] succ = new int[n];
        long[] a = new long[k + 1];
        long res = new Long("10000000000000");
        int kk = 0;
        if (m == 1000000) System.out.println(-1);  
        else {
        for (int i =0 ;i < m; i++)   {
            kk = in.nextInt();
            can[kk] = true;
        }    
        int mingap = 0;
        int len = 0;
        for (int i = 0; i <= n - 1; i++)   {
            if (i == 0 || !can[i]) {
                 succ[i] = i;
                 if (mingap < len) mingap  = len;
                 len = 0;
            }
            else {succ[i] = succ[i - 1]; len++;}
 
        }   
        if (mingap < len) mingap  = len;
        for (int i = 1; i <= k; i++) {
            kk = in.nextInt();
            a[i] = kk;
        }    
        if (k <= mingap || can[0]) System.out.println(-1);
        else  {
            long cnt = 0;
            int flag= 0;
            for (int i = mingap + 1; i <= k; i++)   {
                flag = 0;
                cnt = 1;
                if (i == n || res > (n/i + 1) * a[i]) {
                while (succ[flag] + i < n)   {
                    cnt++;
                    flag = succ[flag] + i;  
                }             
                if (res > cnt * a[i])  res = cnt * a[i];
                }
            }    
            System.out.println(res);
        }            
        }
    }    
}    