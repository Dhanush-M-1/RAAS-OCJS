//  package com.company;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    public static void main(String args[]){
        PrintWriter out=new PrintWriter(System.out);
        InputReader in=new InputReader(System.in);
        TASK solver = new TASK();
//        int t = in.nextInt();
        int t=1;
        /*
         ** @author Jigar_Nainuji
         ** SVNIT-SURAT
         */
        for(int i=0;i<t;i++)
        {
            solver.solve(in,out,i);
        }
        out.close();
    }
    static class TASK {
        static int mod = 998244353;
        void solve(InputReader in, PrintWriter out, int testNumber) {
            long aa[] = new long[30];
            aa[1]=1;
            for(int i=2;i<30;i++)
            {
                aa[i]=(10l*aa[i-1])%mod;
//                System.out.println(aa[i]);
            }
            int n = in.nextInt();
            long a[] = new long[n];
            long dp[] = new long[11];
            long ans=0;
            for(int i=0;i<n;i++)
            {
                a[i]=in.nextLong();
                String s = String.valueOf(a[i]);
                dp[s.length()]++;
            }
            for(int i=0;i<n;i++)
            {
//                System.out.println(i);
                long x = a[i];
                int count=1;
                long sum=0;
                while (x>0)
                {
                    long xx = x%10;
                    for(int j=1;j<=10;j++)
                    {
                        long yy = dp[j];
                        long sum1=0;
                        if(yy==0)
                            continue;
                        if(count<=j)
                        {
                            sum1 = (sum1+(xx*aa[2*count])%mod)%mod;
                            sum1 = (sum1+(xx*aa[2*count-1])%mod)%mod;

                        }
                        else
                        {
                            sum1=(sum1+(xx*aa[j+count])%mod)%mod;
                            sum1=(sum1+(xx*aa[j+count])%mod)%mod;
                        }
                        sum = (sum +(sum1 * yy)%mod)%mod;
//                        System.out.println(sum);

                    }
                    count++;
                    x/=10;
                }
               ans =(ans+(sum)%mod)%mod;
            }

            System.out.println(ans);

        }
    }

    static class pair{
        int x;
        int y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }

    }
    static class Maths{
        static int gcd(int a, int b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }



        public static long factorial(int n){
            long fact = 1;
            for(int i=1;i<=n;i++){
                fact *= i;
            }
            return fact;
        }
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

