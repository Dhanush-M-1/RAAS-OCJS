//package er85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class fourth {

	static int n;
    // static StringBuilder f(long l, long, r, StringBuilder sb) {
 
    // }
 
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
 
        int T = in.nextInt();
        for (int i=0;i<T;i++) {
            n = in.nextInt();
            long l = in.nextLong()-1;
            long r = in.nextLong();
 
            StringBuilder ans = new StringBuilder();
            long index = 0L;
            for (int j=n-1;j>=1;j--) {
                long a = index;
                long b = index+2*j;
                if (b<=l || r<=a) {
                } else {
                    int[] nums = new int[2*j];
                    for (int k=0;k<j;k++) {
                        nums[2*k] = n-j;
                        nums[2*k+1] = n-j+k+1;
                    }
                    for (long k=Math.max(l, a);k<Math.min(r, b);k++) {
                        ans.append(nums[(int)(k-a)]);
                        ans.append(" ");
                    }
                }
                index += 2*j;
            }
            if (r==(long)n*(n-1)+1) {
                ans.append(1);
                ans.append(" ");
            }
            ans.deleteCharAt(ans.length()-1);
            out.println(ans);
            // StringBuilde sb = new StringBuilder();
            // out.println(f(l, r, sb));
        }
 
        out.close();
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