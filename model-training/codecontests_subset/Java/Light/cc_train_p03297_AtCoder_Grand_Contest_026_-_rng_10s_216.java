import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import java.util.*;

public class Main {

    static long gcd(long a,long b) {
        long temp;
        while ((temp=a%b)!=0) {
            a=b;
            b=temp;
        }
        return b;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int T = in.nextInt();
        for (int i=0;i<T;i++) {
            long A = in.nextLong();
            long B = in.nextLong();
            long C = in.nextLong();
            long D = in.nextLong();
            if (A<B || D<B) {
                out.println("No");
                continue;
            }
            if (gcd(B, D)==1) {
                if (B-1<=C) out.println("Yes");
                else out.println("No");
                continue;
            } else {
                long GCD = gcd(B, D);
                // out.println("GCD"+GCD);
                if (A<C) {
                    A+=D*(C-A+D-1)/D;
                }
                // out.println(A);
                // long ok = 0;
                // long ng = 5000000000000000000;
                // while (Math.abs(ok-ng)>1) {
                //     long mid = (ok+ng)/2;
                //     if (A-GCD*mid>C) ok=mid;
                //     else ng=mid;
                // }
                long ok = (A-C)/GCD;
                if ((A-C)%GCD==0) ok--;
                // out.println("ok"+ok);
                long value = A-GCD*ok-B;
                if (value>=0) out.println("Yes");
                else out.println("No");
                // long yy = (A-C)*GCD/B;
                // long ff = A-B/GCD*yy;
                // out.println(yy);
                // out.println(ff);
            }
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
